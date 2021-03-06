package com.udacity.vehicles.client.prices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */

public class Price {

    @JsonProperty("vehicleId")
    private Long vehicleId;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("price")
    private BigDecimal price;

    public Price() {
    }

    public Price(Long vehicleId,String currency, BigDecimal price) {
        this.vehicleId = vehicleId;
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
