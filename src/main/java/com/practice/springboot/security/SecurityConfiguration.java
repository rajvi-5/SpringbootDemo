package com.practice.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    protected InMemoryUserDetailsManager userDetailsService(){
        //Setting configurations in auth
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("rajvi").password("rajvi").roles("admin_role").build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("manan").password("manan").roles("student").build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.
                httpBasic()
                .and()
                .formLogin();
               // .authorizeRequests().anyRequest().fullyAuthenticated();
        return http.build();
    }
    // For password encoding
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //returns password in plain text only
    }
}
