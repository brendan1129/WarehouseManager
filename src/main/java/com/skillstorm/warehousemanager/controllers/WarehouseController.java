package com.skillstorm.warehousemanager.controllers;

import com.skillstorm.warehousemanager.models.Warehouse;
import com.skillstorm.warehousemanager.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "http://localhost:5173", maxAge = 4800)
@RestController
@RequestMapping("api/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/findByCompanyName")
    public List<Warehouse> findWarehousesByCompanyName(@RequestParam String companyName) {
        return warehouseService.findWarehousesByCompanyName(companyName);
    }
    // Create a new warehouse
    @PostMapping("/create")
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.createWarehouse(warehouse);
    }

    // Read all warehouses
    @GetMapping("/getAll")
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    // Read a warehouse by ID
    @GetMapping("/{warehouseId}")
    public Optional<Warehouse> getWarehouseById(@PathVariable Integer warehouseId) {
        return warehouseService.getWarehouseById(warehouseId);
    }

    // Update a warehouse by ID
    @PutMapping("/{warehouseId}/update")
    public Warehouse updateWarehouse(@PathVariable Integer warehouseId, @RequestBody Warehouse updatedWarehouse) {
        return warehouseService.updateWarehouse(warehouseId, updatedWarehouse);
    }

    // Delete a warehouse by ID
    @DeleteMapping("/{warehouseId}/delete")
    public void deleteWarehouse(@PathVariable Integer warehouseId) {
        warehouseService.deleteWarehouse(warehouseId);
    }
}