/*
package ru.sberbank.jd.config;


import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).
        authorizeHttpRequests(requests -> {
            requests.requestMatchers(new AntPathRequestMatcher("/"), new AntPathRequestMatcher("/style.css")).permitAll();
        });
          */
/*  .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
            .logout(LogoutConfigurer::permitAll);*//*


        return http.build();
    }

   */
/* @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("d")
                .username("d")
                .password("")
                .roles("DEV")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*//*

}
*/
