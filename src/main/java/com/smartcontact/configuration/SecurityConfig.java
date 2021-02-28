package com.smartcontact.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception {
    	security.authorizeRequests()
    	.antMatchers("/admin/**").hasRole("ADMIN")
    	.antMatchers("/user/**").hasRole("USER").antMatchers("/")
    	.permitAll().and().formLogin().and().csrf().disable();
    	
  
    }
    
    @Bean
    public UserDetailsService getUserDetailServiceImpl() {
    	return new UserDetailsServiceImpl();
    }
    
    
    @Bean 
    public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
    	
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(getUserDetailServiceImpl());
    	daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
    	return daoAuthenticationProvider;
    	
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
	}
    

  
}