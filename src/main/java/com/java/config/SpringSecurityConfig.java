package com.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@EnableWebSecurity
@DependsOn("myService")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Autowired
	private MyService myservice;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("payal").password("payal").and()
		 * .withUser("admin").password("admin");
		 */
		// auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery("select email,
		// password from user")

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder());
		provider.setUserDetailsService(myservice);
		auth.authenticationProvider(provider);
	}

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().hasRole("user").and().formLogin().loginPage("/login").successForwardUrl("/welcome").failureForwardUrl("/login?error=true");
	}
}
