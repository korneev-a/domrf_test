package com.example.domrf_test.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("customer")
                .password(encoder.encode("password"))
                .roles("CUSTOMER")
                .and()
                .withUser("admin")
                .password(encoder.encode("pass"))
                .roles("EMPLOYEE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .logoutSuccessUrl("/login")
                .and().csrf().disable();
        http
                .authorizeRequests().antMatchers("/", "/login").permitAll()
                .antMatchers("/order/**")
                .access("hasAnyRole('EMPLOYEE')")
                .and().formLogin().and().csrf().disable();

    }
}
