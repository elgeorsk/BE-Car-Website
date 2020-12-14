package com.udacity.vehicles.service;

import com.udacity.vehicles.client.maps.MapsClient;
import com.udacity.vehicles.client.prices.PriceClient;
import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.car.CarRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import com.udacity.vehicles.domain.manufacturer.Manufacturer;
import com.udacity.vehicles.domain.manufacturer.ManufacturerRepository;
import org.springframework.stereotype.Service;

/**
 * Implements the car service create, read, update or delete
 * information about vehicles, as well as gather related
 * location and price data when desired.
 */
@Service
public class CarService {

    private final CarRepository carRepository;
    private final ManufacturerRepository manufacturerRepository;

    private MapsClient mapsClient;
    private PriceClient priceClient;

    public CarService(CarRepository carRepository, ManufacturerRepository manufacturerRepository, MapsClient mapsClient, PriceClient priceClient) {
        this.manufacturerRepository = manufacturerRepository;
        /**
         * Done: Add the Maps and Pricing Web Clients you create
         *   in `VehiclesApiApplication` as arguments and set them here.
         */
        this.mapsClient = mapsClient;
        this.priceClient = priceClient;
        this.carRepository = carRepository;
    }

    /**
     * Gathers a list of all vehicles
     * @return a list of all vehicles in the CarRepository
     */
    public List<Car> list() {
        if (!carRepository.findAll().isEmpty()) {
            List<Car> cars =  carRepository.findAll();
            for (int i=0; i<cars.size(); i++){
                cars.get(i).setPrice(priceClient.getPrice(cars.get(i).getId()));
                cars.get(i).setLocation(mapsClient.getAddress(cars.get(i).getLocation()));
            }
            return cars;
        } else {
            return Collections.emptyList();
        }
    }

    public List<Manufacturer> listMan() {
        if (!manufacturerRepository.findAll().isEmpty()) {
            List<Manufacturer> mans =  manufacturerRepository.findAll();
            return mans;
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Gets car information by ID (or throws exception if non-existent)
     * @param id the ID number of the car to gather information on
     * @return the requested car's information, including location and price
     */
    public Car findById(Long id) {
        /**
         * Done: Find the car by ID from the `repository` if it exists.
         *   If it does not exist, throw a CarNotFoundException
         *   Remove the below code as part of your implementation.
         */
        Car car = carRepository.findById(id).orElseThrow(CarNotFoundException::new);

        /**
         * DONE: Use the Pricing Web client you create in `VehiclesApiApplication`
         *   to get the price based on the `id` input'
         * DONE: Set the price of the car
         * Note: The car class file uses @transient, meaning you will need to call
         *   the pricing service each time to get the price.
         */
        car.setPrice(priceClient.getPrice(car.getId()));

        /**
         * Done: Use the Maps Web client you create in `VehiclesApiApplication`
         *   to get the address for the vehicle. You should access the location
         *   from the car object and feed it to the Maps service.
         * Done: Set the location of the vehicle, including the address information
         * Note: The Location class file also uses @transient for the address,
         * meaning the Maps service needs to be called each time for the address.
         */
        car.setLocation(mapsClient.getAddress(car.getLocation()));
        return car;
    }

    /**
     * Either creates or updates a vehicle, based on prior existence of car
     * @param car A car object, which can be either new or existing
     * @return the new/updated car is stored in the repository
     */
    public Car save(Car car) {
        boolean manCode = manufacturerRepository.findById(car.getDetails().getManufacturer().getCode()).isPresent();
        if (carRepository.findById(car.getId()).isPresent() && manCode) {
            return carRepository.findById(car.getId())
                    .map(carToBeUpdated -> {
                        carToBeUpdated.setDetails(car.getDetails());
                        carToBeUpdated.setLocation(car.getLocation());
                        carToBeUpdated.setCondition(car.getCondition());
                        carToBeUpdated.setModifiedAt(LocalDateTime.now());
                        return carRepository.save(carToBeUpdated);
                    }).orElseThrow(CarNotFoundException::new);
        }
        if (manCode){
            return carRepository.save(car);
        } else {
            throw new ManufacturerNotFoundException();
        }
    }

    /**
     * Deletes a given car by ID
     * @param id the ID number of the car to delete
     */
    public void delete(Long id) {
        /**
         * Done: Find the car by ID from the `repository` if it exists.
         *   If it does not exist, throw a CarNotFoundException
         */
        Car car = carRepository.findById(id).orElseThrow(CarNotFoundException::new);

        /**
         * Done: Delete the car from the repository.
         */
        carRepository.delete(car);
    }
}
