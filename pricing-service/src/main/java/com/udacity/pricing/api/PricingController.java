package com.udacity.pricing.api;

import com.udacity.pricing.entity.Price;
import com.udacity.pricing.service.PricingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements a REST-based controller for the pricing service.
 */
@RestController
@RequestMapping("/services/price")
public class PricingController {

    private final PricingService pricingService;

    PricingController(PricingService pricingService){
        this.pricingService = pricingService;
    }


    /**
     * Gets the price for a requested vehicle.
     * @param vehicleId ID number of the vehicle for which the price is requested
     * @return price of the vehicle, or error that it was not found.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Price get(@RequestParam Long vehicleId) {
            return pricingService.findById(vehicleId);
    }
}
