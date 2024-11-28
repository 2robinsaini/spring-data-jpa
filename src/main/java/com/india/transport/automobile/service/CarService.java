package com.india.transport.automobile.service;

import com.india.transport.automobile.dto.CarDto;
import com.india.transport.automobile.entity.Car;

import java.util.List;

public interface CarService {

    public List<CarDto> getAllCars();
    public List<CarDto> saveCar(CarDto newCar);
    public List<CarDto> saveCars(List<CarDto> newCars);
    public List<CarDto> removeCar(Long id);
    public List<CarDto> updateCar(Long id,CarDto carDto);

}
