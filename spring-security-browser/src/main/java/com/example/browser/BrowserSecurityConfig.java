package com.example.browser;

import com.example.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String loginPage = securityProperties.getBrowserProperties().getLoginPage();
        System.out.println(loginPage);
        http.formLogin()
                .loginPage(loginPage)
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()
                .antMatchers(loginPage).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
