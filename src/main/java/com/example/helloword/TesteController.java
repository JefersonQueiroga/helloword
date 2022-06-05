package com.example.helloword;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @RequestMapping("/teste")
    public String teste(){
        System.out.println("---- Testando -------");
        return "####Tes";
    }

    @RequestMapping("/teste3")
    public String teste2(){
        return "####Carro";
    }
}
