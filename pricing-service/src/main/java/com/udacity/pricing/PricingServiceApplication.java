package com.udacity.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * Creates a Spring Boot Application to run the Pricing Service.
 * Done: Convert the application from a REST API to a microservice.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class PricingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }

    /*@Bean
    CommandLineRunner initDatabase(PriceRepository repository) {
        PricingController pricingController = new PricingController();
        return args -> {
            repository.save(pricingController.get(1L));
            repository.save(pricingController.get(2L));
            repository.save(pricingController.get(3L));
            repository.save(pricingController.get(4L));
            repository.save(pricingController.get(5L));
            repository.save(pricingController.get(6L));
            repository.save(pricingController.get(7L));
            repository.save(pricingController.get(8L));
            repository.save(pricingController.get(9L));
            repository.save(pricingController.get(10L));
            repository.save(pricingController.get(11L));
            repository.save(pricingController.get(12L));
            repository.save(pricingController.get(13L));
            repository.save(pricingController.get(14L));
            repository.save(pricingController.get(15L));
            repository.save(pricingController.get(16L));
            repository.save(pricingController.get(17L));
            repository.save(pricingController.get(18L));
            repository.save(pricingController.get(19L));
        };
    }*/

}
