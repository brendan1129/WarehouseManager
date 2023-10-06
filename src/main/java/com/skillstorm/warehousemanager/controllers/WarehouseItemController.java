package com.skillstorm.warehousemanager.controllers;

import com.skillstorm.warehousemanager.models.WarehouseItem;
import com.skillstorm.warehousemanager.services.WarehouseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouse-items")
@CrossOrigin(origins= {"http://localhost:5173"}, maxAge = 4800)
public class WarehouseItemController {

    private final WarehouseItemService warehouseItemService;

    @Autowired
    public WarehouseItemController(WarehouseItemService warehouseItemService) {
        this.warehouseItemService = warehouseItemService;
    }

    @GetMapping
    public ResponseEntity<List<WarehouseItem>> getAllItems() {
        List<WarehouseItem> items = warehouseItemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<WarehouseItem> getItemById(@PathVariable Long itemId) {
        Optional<WarehouseItem> item = warehouseItemService.getItemById(itemId);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<WarehouseItem> addItem(@RequestBody WarehouseItem item) {
        WarehouseItem newItem = warehouseItemService.addItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable Long itemId, @RequestBody WarehouseItem newItem) {
        warehouseItemService.updateItem(itemId, newItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        warehouseItemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{companyName}/{warehouseName}")
    public ResponseEntity<List<WarehouseItem>> findItemsByWarehouseName(@PathVariable String warehouseName, @PathVariable String companyName) {
            // Now you can use the decodedParameter in your database query
            // For example, query for items with the decodedParameter as the name
            List<WarehouseItem> items = warehouseItemService.findItemsByWarehouseAndCompanyName(warehouseName, companyName);
            return new ResponseEntity<>(items, HttpStatus.OK);

    }
    @GetMapping("/by-warehouse-id/{warehouse_id}")
    public ResponseEntity<List<WarehouseItem>> findItemsByWarehouseName(@PathVariable Long warehouse_id) {
        List<WarehouseItem> items = warehouseItemService.findItemsByWarehouseID(warehouse_id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @PostMapping("/{itemId}/reduce-quantity/{reductionAmount}")
    public ResponseEntity<String> reduceItemQuantity(
            @PathVariable Long itemId,
            @PathVariable int reductionAmount) {
        System.out.println("What the fuck is even happening");
        try {
            warehouseItemService.reduceItemQuantity(itemId, reductionAmount);
            return ResponseEntity.ok("Quantity reduced successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}