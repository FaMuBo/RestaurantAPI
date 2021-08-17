package com.exampleFinartz.demo.Security;

import com.exampleFinartz.demo.exception.GlobalSecurityExceptionHandler;
import com.exampleFinartz.demo.filter.CustomAuthenticationFilter;
import com.exampleFinartz.demo.filter.CustomAuthorizationFilter;
import com.exampleFinartz.demo.models.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login"); // login url can change with this line

        http.authorizeRequests().antMatchers("/login/**", "/user/refresh-token/**").permitAll();
        http.authorizeRequests().antMatchers("/restaurant/waiting/**").hasAnyAuthority(Role.ADMIN.toString());
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/restaurant").hasAnyAuthority(Role.ADMIN.toString());
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/restaurant").hasAnyAuthority(Role.SELLER.toString());
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/comment").hasAnyAuthority(Role.CUSTOMER.toString());
        http.authorizeRequests().antMatchers("/h2/**").permitAll();

//      http.authorizeRequests().anyRequest().permitAll();   // It throws SpringSecurity out of picture.

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable(); // cross-side request forgery
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.headers().frameOptions().sameOrigin();

//      http.headers().frameOptions().disable();

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (AccessDeniedHandler) new GlobalSecurityExceptionHandler();
    }
}