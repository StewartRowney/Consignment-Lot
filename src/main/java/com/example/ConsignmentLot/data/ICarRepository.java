package com.example.ConsignmentLot.data;

import com.example.ConsignmentLot.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ICarRepository extends ListCrudRepository<Car, UUID> {
    List<Car> findCarsByOwnerName(String name);
}
