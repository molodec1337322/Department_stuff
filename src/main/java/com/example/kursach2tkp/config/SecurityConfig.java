package com.example.kursach2tkp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@ComponentScan(basePackages = "com.example.kursach2tkp")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user")).roles("USER");

         */

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/workers", "/workers/*", "/subjects").permitAll()
                .antMatchers("/auth/registration", "/auth/registration/*", "/auth/login", "/auth/login/*").not().fullyAuthenticated()
                .antMatchers("/workers/new", "/subjects/new").fullyAuthenticated()
                .anyRequest().authenticated()
                .and()

                .formLogin()
                // указываем страницу с формой логина
                .loginPage("/auth/login")
                .defaultSuccessUrl("/subjects", true)
                // указываем action с формы логина
                .loginProcessingUrl("/auth/login_processing")
                // указываем URL при неудачном логине
                .failureUrl("/auth/login?error")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("login")
                .passwordParameter("password")
                // даем доступ к форме логина всем
                .permitAll();
    }
}
