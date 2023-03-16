// WebSecurityConfigurerAdapter deprecated since spring-security 5.7.2
// refer https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
//package com.practice.springboot.security;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfigurationOld extends WebSecurityConfigurerAdapter {
//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        //Setting configurations in auth
//        auth.inMemoryAuthentication()
//                .withUser("rajvi").password("rajvi").roles("admin_role")
//                .and()
//                .withUser("manan").password("manan").roles("student");
//    }
//    // Configuring the api
//    // according to the roles.
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.
//                httpBasic()
//                .and()
//                .authorizeRequests().anyRequest().fullyAuthenticated();
//                //for mapping specific services and not authenticating fully
//                /*.and()
//                .authorizeRequests()
//                .antMatchers("/delete/**").hasRole("admin_role")
//                .antMatchers("/rest/**").hasAnyRole("admin_role","student")
//                .antMatchers("/").permitAll()*/
//                //for form based login
//                /*.and()
//                .formLogin();*/
//    }
//// For password encoding
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance(); //returns password in plain text only
//    }
//}
