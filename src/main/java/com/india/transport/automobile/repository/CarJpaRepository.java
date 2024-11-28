package com.india.transport.automobile.repository;

import com.india.transport.automobile.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<Car,Long> {
}
