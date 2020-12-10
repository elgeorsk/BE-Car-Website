package com.udacity.boogle.maps;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
public class BoogleMapsService {

    public Address getAddress(Double lat, Double lon, RestTemplate restTemplate) throws Exception{

        // get location through https://positionstack.com/ service
        AddressList response =
                restTemplate.getForObject("http://api.positionstack.com/v1/reverse?access_key=32ef55e27ee591f252faa69b103be236&query="+lat+ ","+lon +"&limit=1&output=json", AddressList.class);

        return response.getData().get(0);
        //return new Address(streetAndNumber, city, state, zip);
    }
}
