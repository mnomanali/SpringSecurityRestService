package com.search.sequence.commutebuddy.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);
	
	/* 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.withUser(
					User.withUsername("user")
					.password("pass")
					.roles("USER")
			)
			.withUser(
					User.withUsername("admin")
						.password("pass")
						.roles("ADMIN")
					);
			
	} */
	
	@Autowired
	private CustomAuthenticationProviderService  authenticationProviderService;	
	
	
	/* for Authentication */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("Its coming to AuthenticationManagerBuilder ");
		log.info("---------------------------------------- CS2Security - AuthenticationManagerBuilder - 1");
		auth.authenticationProvider(authenticationProviderService);
	}
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("pass")
		.authorities("USER")
		.and()
		.withUser("admin")
		.password("test")
		.authorities("ADMIN");
	}
	*/
	
	// /user will only guard the /user and all others can go easily with /user/all
	// /user will guard everything beyond that boundary for example /user/all or /user/byid
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
		.httpBasic() //httpBasic allow to send the credential to http header
		.and().csrf().disable() // csrf disabled will be helpful if someone is using your service without browser client
		.authorizeRequests() //only following giving authorize users are allowed to use services
		//.antMatchers("/submissions/admin").hasAuthority("ADMIN")
			//.antMatchers("/submissions/user").hasAnyAuthority("ADMIN", "USER")
			.antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
			.antMatchers("/configuration/**", "/swagger*", "/webjars/**").hasAnyAuthority("ADMIN", "USER")
			//.antMatchers("/").permitAll()
			.anyRequest().authenticated() //everything needs to be authenticated
			.and().formLogin()
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID");
	}
	
	
}
