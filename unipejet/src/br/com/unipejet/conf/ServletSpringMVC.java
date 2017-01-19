package br.com.unipejet.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.unipejet.viewresolver.Agendamento;
import br.com.unipejet.viewresolver.MyJob;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{SecurityConfiguration.class,
				AppWebConfiguration.class,JPAConfiguration.class, Agendamento.class, MyJob.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	// Define o local de armazenamneto temporário do arquivo enviado, a string vazia diz que o servidor web é quem decide
	@Override
	protected void customizeRegistration(Dynamic registration) {
	registration.setMultipartConfig(
	new MultipartConfigElement(""));
	}
	
	
	@Override
	protected Filter[] getServletFilters() {
	return new Filter[]{
	new OpenEntityManagerInViewFilter()};
	}
	
}
