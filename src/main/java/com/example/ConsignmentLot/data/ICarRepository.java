package com.example.ConsignmentLot.data;

import com.example.ConsignmentLot.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends ListCrudRepository<Car, Long> {

    List<Car> findCarsByOwnerName(String name);
}
