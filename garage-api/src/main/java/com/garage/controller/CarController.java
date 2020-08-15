package com.garage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.document.Car;
import com.garage.exception.GarageApiException;
import com.garage.model.Warehouse;
import com.garage.service.CarService;
import com.garage.service.WarehouseService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Controller layer to handle HTTP requests
 *
 */
@Slf4j
@RestController
@RequestMapping("/garage/api/v1")
public class CarController {
	
	private static final String PATH_CAR = "/cars";
	
	@Autowired
	private WarehouseService warehouseService;
	
	@Autowired
	private CarService carService;

	@GetMapping(PATH_CAR)
	public Mono<List<Warehouse>> getCars() {
		try {
			return warehouseService.getCars();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new GarageApiException(ex.getMessage(), ex);
		}
	}
	
	@PostMapping(PATH_CAR)
	public Mono<Car> addCar(@RequestBody Car car) {
		try {
			return carService.create(car);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new GarageApiException(ex.getMessage(), ex);
		}
	}
	
	@PutMapping(PATH_CAR)
	public Mono<Car> updateCar(@RequestBody Car car) {
		try {
			return carService.update(car);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new GarageApiException(ex.getMessage(), ex);
		}
	}
	
	@DeleteMapping(PATH_CAR+"/{id}")
	public Mono<Void> deleteCar(@PathVariable("id") Integer id) {
		try {
			return carService.delete(id);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new GarageApiException(ex.getMessage(), ex);
		}
	}

}