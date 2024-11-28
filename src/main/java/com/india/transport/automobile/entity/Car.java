package com.india.transport.automobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "car")
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "car_price")
    private Float carPrice;

    @Column(name = "car_model_name")
    private String carModelName;

    @Column(name = "mfg_year")
    private Integer mfgYear;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "car_type")
    private String carType;

}
