package com.india.transport.automobile.dto;

import java.io.Serializable;

public record CarDto (String companyName, Float carPrice, String carModelName, Integer mfgYear, String fuelType, String carType) implements Serializable {

}
