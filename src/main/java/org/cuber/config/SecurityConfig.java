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
        http.authorizeRequests().antMatchers("/login.htm").anonymous().and()
                .authorizeRequests().antMatchers("/error").anonymous().and()
                .authorizeRequests().antMatchers("/resources/**").anonymous().and()
                .authorizeRequests().antMatchers("/userRegistration.htm/**").anonymous().and()
                .authorizeRequests().antMatchers("/test.htm/**").anonymous().and()
                .authorizeRequests().antMatchers("/admin.htm").hasRole("ADMIN").and()
                .formLogin()
                    .loginPage("/login.htm")
                    .loginProcessingUrl("/login")  //very import add
                    .failureUrl("/loginfailed.htm");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userSearchBase("ou=people").userSearchFilter("uid={0}")
                .groupSearchBase("ou=roles")
                .contextSource()
                .url("ldap://127.0.0.1:389/dc=cucumber,dc=com")
                .managerDn("cn=manager,dc=cucumber,dc=com")
                .managerPassword("secret");

    }
}
