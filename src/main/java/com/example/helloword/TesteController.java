package com.example.helloword;


import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.Collections;
import java.util.Map;

@RestController
public class TesteController {


    @GetMapping("/home")
    public String home(final Model model, final OAuth2AuthenticationToken token) {
        return "index";
    }

    @RequestMapping("/")
    public Map<String, Object> home(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("code", principal.getAttribute("code"));
    }
    @RequestMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("display_name"));
    }

    @RequestMapping("/teste")
    public String teste(){
        System.out.println("---- Testando -------: ");
        return "####Tes";
    }

    @RequestMapping("/callback")
    public String callback(@RegisteredOAuth2AuthorizedClient("code") OAuth2AuthorizedClient oauth2AuthorizedClient){
        System.out.println("# 55555 Testando -------: " + oauth2AuthorizedClient.getPrincipalName());
        return "####Tes";
    }

    @RequestMapping("/teste3")
    public String teste2(){
        return "####Carro";
    }
}
