package com.udacity.boogle.maps;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/maps")
public class BoogleMapsController {

    private BoogleMapsService boogleMapsService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    BoogleMapsController(BoogleMapsService boogleMapsService){
        this.boogleMapsService = boogleMapsService;
    }

    @GetMapping
    public Address get(@RequestParam Double lat, @RequestParam Double lon, RestTemplate restTemplate) throws Exception {

        return boogleMapsService.getAddress(lat,lon, restTemplate);
        //return MockAddressRepository.getRandom();
    }
}
