package br.com.unipejet.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService users;
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {
	auth.userDetailsService(users).
	passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/listar").hasRole("ADMIN")
	.antMatchers("/remove_usuario").hasRole("ADMIN")
	.antMatchers(HttpMethod.POST,"/produtos").hasRole("ADMIN")
	.antMatchers("/novo_usuario").hasRole("ADMIN")
	.antMatchers("/voos/cad_voos").hasRole("ADMIN")
	.antMatchers("/voos/listar_voos").hasRole("ADMIN")
	.antMatchers("/voos/edita_voo").hasRole("ADMIN")
	.antMatchers("voos/remove_voo").hasRole("ADMIN")
	.antMatchers("/cadastro/**").permitAll()
	.antMatchers("/salva_usuario_cadastro").permitAll()
	.antMatchers("/editar").permitAll()
	.anyRequest().authenticated()
	.and().formLogin().loginPage("/login").permitAll()  
	.and()
	.logout()
    .addLogoutHandler(customLogoutHandler()) 
    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	/*
	
	.logout().logoutRequestMatcher(new AntPathRequestMatcher(
	"/logout"));
	
	*/
	}
	
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
	
	@Bean
	public CustomLogoutHandler customLogoutHandler() {
	    return new CustomLogoutHandler();
	}
	
	}
	

