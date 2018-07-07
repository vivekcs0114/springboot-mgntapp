package com.synerzip.college.repository;

import com.synerzip.college.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    public Car findByName(String name);
}
