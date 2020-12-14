package com.udacity.vehicles.api;

import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.manufacturer.Manufacturer;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Maps the CarController to the Car class using HATEOAS
 */
@Component
public class ManufacturerResourceAssembler implements ResourceAssembler<Manufacturer, Resource<Manufacturer>> {

    @Override
    public Resource<Manufacturer> toResource(Manufacturer man) {
        return new Resource<>(man);
    }
}
