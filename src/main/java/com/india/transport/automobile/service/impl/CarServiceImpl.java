package com.india.transport.automobile.service.impl;

import com.india.transport.automobile.dto.CarDto;
import com.india.transport.automobile.entity.Car;
import com.india.transport.automobile.repository.CarCrudRepository;
import com.india.transport.automobile.repository.CarJpaRepository;
import com.india.transport.automobile.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    Logger logger =  LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarJpaRepository carJpaRepository;

    @Autowired
    private CarCrudRepository carCrudRepository;

    @Override
    public List<CarDto> getAllCars() {
        logger.info("getAllCars called");
        List<Car> cars = carJpaRepository.findAll();
        logger.info("{} car found",cars.size());
        return getCarDtoFromCarEntity(cars);
    }

    @Override
    public List<CarDto> removeCar(Long id) {
        logger.info("getAllCars called");
        carCrudRepository.deleteById(id);
        List<Car> cars = carJpaRepository.findAll();
        logger.info("{} car found",cars.size());
        return getCarDtoFromCarEntity(cars);
    }

    @Override
    public List<CarDto> updateCar(Long id, CarDto carDto) {
        Optional<Car> car = carCrudRepository.findById(id);
        car.ifPresent(c -> {
            Car newCar = getCarEntityFromCarDto(carDto);
            newCar.setId(id);
            carCrudRepository.save(newCar);
        });
        List<Car> cars = carJpaRepository.findAll();
        logger.info("{} car found",cars.size());
        return getCarDtoFromCarEntity(cars);
    }

    @Override
    public List<CarDto> saveCar(CarDto newCar) {
        logger.info("save car called");
        Car car = getCarEntityFromCarDto(newCar);
        carJpaRepository.save(car);
        List<Car> cars = carJpaRepository.findAll();
        logger.info("{} car found",cars.size());
        return getCarDtoFromCarEntity(cars);
    }

    @Override
    public List<CarDto> saveCars(List<CarDto> newCars) {
        logger.info("save car called");
        List<Car> cars = getCarsEntityFromCarDtos(newCars);
        carJpaRepository.saveAll(cars);
        List<Car> carsList = carJpaRepository.findAll();
        logger.info("{} car found",carsList.size());
        return getCarDtoFromCarEntity(carsList);
    }

    private List<CarDto> getCarDtoFromCarEntity(List<Car> cars){
        List<CarDto> carDtos = new ArrayList<>();
        for(Car car : cars){
            CarDto carDto = new CarDto(car.getCompanyName(),car.getCarPrice(),car.getCarModelName(),car.getMfgYear(),car.getFuelType(),car.getCarType());
            carDtos.add(carDto);
        }
        return carDtos;
    }

    private List<Car> getCarsEntityFromCarDtos(List<CarDto> carDtos){
        List<Car> cars = new ArrayList<>();
        for(CarDto carDto : carDtos) {
            Car car = getCarEntityFromCarDto(carDto);
            cars.add(car);
        }
        return cars;
    }

    private Car getCarEntityFromCarDto(CarDto carDto){
        Car car = new Car();
        car.setCarPrice(carDto.carPrice());
        car.setCarType(carDto.carType());
        car.setFuelType(carDto.fuelType());
        car.setCarModelName(carDto.carModelName());
        car.setMfgYear(carDto.mfgYear());
        car.setCompanyName(carDto.companyName());
        return car;
    }
}
