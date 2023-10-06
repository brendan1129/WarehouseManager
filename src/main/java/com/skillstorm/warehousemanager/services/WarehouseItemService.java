package com.skillstorm.warehousemanager.services;

import com.skillstorm.warehousemanager.models.Warehouse;
import com.skillstorm.warehousemanager.models.WarehouseItem;
import com.skillstorm.warehousemanager.repositories.WarehouseItemRepository;
import com.skillstorm.warehousemanager.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseItemService {

    private final WarehouseItemRepository warehouseItemRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    static int currentTotal = 0;

    @Autowired
    public WarehouseItemService(WarehouseItemRepository warehouseItemRepository) {
        this.warehouseItemRepository = warehouseItemRepository;
    }

    public List<WarehouseItem> getAllItems() {
        return warehouseItemRepository.findAll();
    }

    public Optional<WarehouseItem> getItemById(Long itemId) {
        return warehouseItemRepository.findById(itemId);
    }

    public WarehouseItem addItem(WarehouseItem item) throws IllegalArgumentException {
        Optional<Warehouse> warehouse = warehouseRepository.findById(item.getWarehouse_id());
        if(warehouse.isPresent()) {
            if(item.getQuantity() + currentTotal > warehouse.get().getMaxCapacity()) {
                throw new IllegalArgumentException("Requested add: " + item.getQuantity() + " + " + currentTotal + " Cannot Exceed Max Capacity: " + warehouse.get().getMaxCapacity() + " of Warehouse " + warehouse.get().getWarehouseName());
            }
            else {
                currentTotal = currentTotal + item.getQuantity();
                return warehouseItemRepository.save(item);
            }
        }
        else {
            throw new IllegalArgumentException("Warehouse Not Found");
        }
    }

    public void updateItem(Long itemId, WarehouseItem newItem) {
        if (warehouseItemRepository.existsById(itemId)) {
            warehouseItemRepository.save(newItem);
        }
    }

    public void deleteItem(Long itemId) {
        WarehouseItem item = warehouseItemRepository.getReferenceById(itemId);
        currentTotal -= item.getQuantity();
        warehouseItemRepository.deleteById(itemId);
    }

    public List<WarehouseItem> findItemsByWarehouseAndCompanyName(String warehouseName, String companyName) {
        return warehouseItemRepository.findByWarehouseAndCompanyName(warehouseName, companyName);
    }

    public List<WarehouseItem> findItemsByWarehouseID(Long warehouse_id) {
        return warehouseItemRepository.findWarehouseItemBy(warehouse_id);
    }
    public void reduceItemQuantity(Long itemId, int reductionAmount) {
        WarehouseItem item = warehouseItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        int currentQuantity = item.getQuantity();
        int newQuantity = currentQuantity - reductionAmount;

        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot go below 0");
        } else if (newQuantity == 0) {
            // Delete the item when quantity reaches 0
            warehouseItemRepository.delete(item);
        } else {
            // Update the item's quantity
            currentTotal -= newQuantity;
            item.setQuantity(newQuantity);
            warehouseItemRepository.save(item);
        }
    }
}