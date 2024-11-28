package com.india.transport.automobile.controller;

import com.india.transport.automobile.dto.CarDto;
import com.india.transport.automobile.entity.Car;
import com.india.transport.automobile.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

     Logger log = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<CarDto> getAllCars(){
        log.info("getAllCars called");
        List<CarDto> cars = carService.getAllCars();
        log.info("Total {} cars found",cars.size());
        return cars;
    }

    @DeleteMapping("/remove/{id}")
    public List<CarDto> removeCar(@PathVariable("id") Long id){
        log.info("removeCar called with id {}",id);
        List<CarDto> cars = carService.removeCar(id);
        log.info("Total {} cars found after remove",cars.size());
        return cars;
    }

    @PostMapping("/addcar")
    public List<CarDto> addNewCar(@RequestBody CarDto newCar){
        log.info("addNewCar called for {} {} ", newCar.companyName(),newCar.carModelName());
        List<CarDto> cars = carService.saveCar(newCar);
        log.info("Total {} cars found",cars.size());
        return cars;
    }

    @PostMapping("/addcars")
    public List<CarDto> addNewCars(@RequestBody List<CarDto> newCars){
        log.info("addNewCars called for {}", newCars.size());
        List<CarDto> cars = carService.saveCars(newCars);
        log.info("Total {} cars found",cars.size());
        return cars;
    }

    @PutMapping("/updatecar/{id}")
    public List<CarDto> updateCars(@RequestBody CarDto newCar,@PathVariable("id") Long id){
        log.info("update Car called for {}", id);
        List<CarDto> cars = carService.updateCar(id,newCar);
        log.info("Total {} cars found",cars.size());
        return cars;
    }

}
