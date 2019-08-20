package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.csrf().disable();
            http
                    .authorizeRequests()
                    .antMatchers("/registration.xhtml").permitAll()
                    .antMatchers("/mainPage.xhtml").permitAll()
                    .antMatchers("/javax.faces.resource/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/logInPage.xhtml")
                    .permitAll()
                    .usernameParameter("phone_number")
                    .passwordParameter("password")
                    .failureUrl("/logInPage.xhtml?error=true")
                    .defaultSuccessUrl("/doctorsPage.xhtml")
                    .and()
                    .logout()
                    .logoutSuccessUrl("/logInPage.xhtml");
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    protected PasswordEncoder dummyPasswordEncoder() {
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT PHONE AS USERNAME, PASSWORD, 1 AS ENABLED FROM SITE_USER WHERE PHONE = ?")
                .authoritiesByUsernameQuery("SELECT PHONE AS USERNAME, ROLE AS ROLE FROM SITE_USER WHERE PHONE = ?");
    }
}