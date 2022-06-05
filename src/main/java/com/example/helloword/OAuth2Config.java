package com.example.helloword;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class OAuth2Config {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/","/teste","/error","/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login();
        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.pipedriveClientRegistration());
    }

    private ClientRegistration pipedriveClientRegistration() {
        return ClientRegistration.withRegistrationId("pipedrive")
                .clientId("1ac90dc9db1424af")
                .clientSecret("0fdc47b869f38ae0128604c23d9e6363c8bb4fc1")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .authorizationUri("https://oauth.pipedrive.com/oauth/authorize")
                .tokenUri("https://oauth.pipedrive.com/oauth/token")
                .clientName("teste")
                .build();
    }
}
