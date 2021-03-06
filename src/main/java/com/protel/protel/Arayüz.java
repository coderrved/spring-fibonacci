package com.protel.protel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class Arayüz {

    @GetMapping("/hesapla")
    public String getDeneme(){
        return "index";
    }

    @PostMapping("/hesapla")
    public String postDeneme(@ModelAttribute(name = "fibonacci") Fibonacci fibonacci, ModelMap model){

        int value = fibonacci.getValue();
        String donenSonuc = getFibonnaci(String.valueOf(value));
        System.out.println(donenSonuc);
        model.put("value", donenSonuc);
        System.out.println("sdfdsf");
        return "logout";
    }

    private static String getFibonnaci(String value)
    {
        final String uri = "http://localhost:8080/api/fibonacci?value=" + value;
        System.out.println("*********** LINK **************: " + uri);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("*********** LINK **************: " + result);
        return result;
    }

}
