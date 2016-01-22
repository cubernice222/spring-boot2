package org.cuber.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by cuber on 2016/1/22.
 */
@Configuration
@AutoConfigureBefore(SecurityAutoConfiguration.class)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login.htm").permitAll().anyRequest().fullyAuthenticated().and()
                .authorizeRequests().antMatchers("/error").permitAll().anyRequest().fullyAuthenticated().and()
                .authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().fullyAuthenticated().and()
                .authorizeRequests().antMatchers("/userRegistration.htm/**").permitAll().anyRequest().fullyAuthenticated().and()
                .authorizeRequests().antMatchers("/test.htm/**").permitAll().anyRequest().fullyAuthenticated().and()
                .authorizeRequests().antMatchers("/admin.htm").access("hasRole('ROLE_admin')").and()
                .formLogin().loginPage("/login.htm");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("cuber").password("cuber").roles("admin");
    }
}
