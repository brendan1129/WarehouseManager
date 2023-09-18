package com.skillstorm.warehousemanager.services;

import com.skillstorm.warehousemanager.models.Warehouse;
import com.skillstorm.warehousemanager.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
    // Create a new warehouse
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    // Read all warehouses
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    // Read a warehouse by ID
    public Optional<Warehouse> getWarehouseById(Integer warehouseId) {
        return warehouseRepository.findById(warehouseId);
    }

    // Update a warehouse
    public Warehouse updateWarehouse(Integer warehouseId, Warehouse updatedWarehouse) {
        Optional<Warehouse> existingWarehouse = warehouseRepository.findById(warehouseId);
        if (existingWarehouse.isPresent()) {
            updatedWarehouse.setWarehouse_id(warehouseId);
            return warehouseRepository.save(updatedWarehouse);
        } else {
            throw new RuntimeException("Warehouse not found with ID: " + warehouseId);
        }
    }

    // Delete a warehouse
    public void deleteWarehouse(Integer warehouseId) {
        warehouseRepository.deleteById(warehouseId);
    }
    public List<Warehouse> findWarehousesByCompanyName(String companyName) {
        return warehouseRepository.findByCompanyName(companyName);
    }
}