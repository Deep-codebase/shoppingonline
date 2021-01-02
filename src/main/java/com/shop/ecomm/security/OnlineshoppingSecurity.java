package com.shop.ecomm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@EnableWebSecurity
public class OnlineshoppingSecurity extends WebSecurityConfigurerAdapter {

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	
	@Autowired
	public OnlineshoppingSecurity(BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/register").permitAll()
		.antMatchers("/manageproduct").hasRole("ADMIN")
//		.antMatchers("/management/showVendor").hasRole("ADMIN")
		.antMatchers("/login").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/**").permitAll()
		.anyRequest()
		.authenticated().and().csrf().disable()
		.formLogin().loginPage("/login").failureUrl("/login?error=true")
		.defaultSuccessUrl("/home", true)
		.usernameParameter("email").passwordParameter("password")
//		.and()
//		.exceptionHandling().accessDeniedPage("/accessDenied")
		.and()
		.logout();
	} 

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  auth
//	         .inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
//	         .withUser("deep").password("$2a$10$rYu5QcPxy.snclCdMfbp8OQBe7.kG8FfClGVnSd6eOLpu3.qAFahO").roles("USER");

		auth.authenticationProvider(customAuthenticationProvider);

	}
}
