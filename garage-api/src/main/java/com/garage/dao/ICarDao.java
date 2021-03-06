package com.garage.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.garage.entity.Car;

/**
 * Dao layer to interact with data source: Mongo DB and to implement database
 * operations using Reactive Programming through Spring Data Reactive
 * Repositories with MongoDB.
 *
 */
@Repository
public interface ICarDao extends ReactiveMongoRepository<Car, Integer> {

}
