package com.example.ConsignmentLot.data;

import com.example.ConsignmentLot.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, UUID> {
}
