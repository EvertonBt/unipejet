package br.com.unipejet.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.google.common.cache.CacheBuilder;

import br.com.unipejet.controllers.UsuarioController;
import br.com.unipejet.daos.UserDAO;
import br.com.unipejet.infra.FileSaver;
import br.com.unipejet.models.Role;
import br.com.unipejet.viewresolver.JsonViewResolver;



@EnableWebMvc
@ComponentScan(basePackageClasses={UsuarioController.class,UserDAO.class,FileSaver.class, Role.class,JsonViewResolver.class})
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	
	@Bean
	public InternalResourceViewResolver
	internalResourceViewResolver() {
	InternalResourceViewResolver resolver =
	new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	//passamos o exato nome da classe que ser� registrada (acessa o objeto sem usar aquela sintaxe sinistra come�ando com Scpp
	resolver.setExposedContextBeanNames("shoppingCart");
	return resolver;
	}

	 
	@Bean
	public MessageSource messageSource(){
	ReloadableResourceBundleMessageSource bundle =
	new ReloadableResourceBundleMessageSource();
	bundle.setBasename("/WEB-INF/messages");
	bundle.setDefaultEncoding("UTF-8");
	bundle.setCacheSeconds(1);
	return bundle;
	}
	

	@Bean
	public FormattingConversionService mvcConversionService() {
	DefaultFormattingConversionService conversionService =
	new DefaultFormattingConversionService(true);
	DateFormatterRegistrar registrar =
	new DateFormatterRegistrar();
	registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
	registrar.registerFormatters(conversionService);
	return conversionService;
	}

	// Necess�rio adicionar para tratamento de dados de formularios enviados usando o multipart-formdata
	@Bean
	public MultipartResolver multipartResolver(){
	return new StandardServletMultipartResolver();
	}
	
  
	// Para injetar o Restemplate
	
	@Bean
	public RestTemplate restTemplate(){
	return new RestTemplate();
	}
	
	/// Classe respons�vel por armazenar os objetos cacheados

	
	@Bean
	public CacheManager cacheManager() {
	CacheBuilder<Object, Object> builder =
	CacheBuilder.newBuilder()
	.maximumSize(100)
	.expireAfterAccess(5, TimeUnit.MINUTES);
	GuavaCacheManager cacheManager = new GuavaCacheManager();
	cacheManager.setCacheBuilder(builder);
	return cacheManager;
	}
	
	// Ensina o spring a responder as requisi��es em formatos diferentes
	

	@Bean
	public ViewResolver contentNegotiatingViewResolver(
	ContentNegotiationManager manager) {
	List<ViewResolver> resolvers =
	new ArrayList<ViewResolver>();
	resolvers.add(internalResourceViewResolver());
	resolvers.add(new JsonViewResolver());
	ContentNegotiatingViewResolver resolver =
	new ContentNegotiatingViewResolver();
	resolver.setViewResolvers(resolvers);
	resolver.setContentNegotiationManager(manager);
	return resolver;
	}
	
	/*
	@Bean
	public static void main(String[] args) {

		ApplicationContext context = 
               new ClassPathXmlApplicationContext
              ("applicationContext.xml");
	}
	*/
	@Override
	public void configureDefaultServletHandling(
	DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
}