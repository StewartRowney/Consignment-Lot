package com.example.ConsignmentLot.data;

import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.entities.Truck;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface ITruckRepository extends ListCrudRepository<Truck, UUID> {

    List<Truck> findTruckByOwnerName(String name);
}
