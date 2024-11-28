package com.india.transport.automobile.repository;

import com.india.transport.automobile.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarCrudRepository extends CrudRepository<Car,Long> {
}
