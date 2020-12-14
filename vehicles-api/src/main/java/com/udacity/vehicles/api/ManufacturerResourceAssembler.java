package com.udacity.vehicles.api;

import com.udacity.vehicles.domain.manufacturer.Manufacturer;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerResourceAssembler implements ResourceAssembler<Manufacturer, Resource<Manufacturer>> {

    @Override
    public Resource<Manufacturer> toResource(Manufacturer man) {
        return new Resource<>(man);
    }
}
