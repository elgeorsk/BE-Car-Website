package com.udacity.vehicles.api;

import com.udacity.vehicles.domain.manufacturer.Manufacturer;
import com.udacity.vehicles.service.CarService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@ApiResponses(value = {
        @ApiResponse(responseCode="400", description  = "This is a bad request, please follow the API documentation for the proper request format.", content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(responseCode="401", description  = "Due to security constraints, your access request cannot be authorized. ",content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(responseCode="500", description  = "The server is down. Please make sure that the Location microservice is running.",content = @Content(schema = @Schema(hidden = true)))
})
@RequestMapping("/manufacturers")
class ManufacturerController {

    private final CarService carService;
    private final ManufacturerResourceAssembler assembler;

    public ManufacturerController(CarService carService, ManufacturerResourceAssembler assembler) {
        this.carService = carService;
        this.assembler = assembler;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Resources<Resource<Manufacturer>> listMans() {
        List<Resource<Manufacturer>> resources = carService.listMan().stream().map(assembler::toResource).collect(Collectors.toList());
        return new Resources<>(resources,
                linkTo(methodOn(ManufacturerController.class).listMans()).withSelfRel());
    }
}
