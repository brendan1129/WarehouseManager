package com.skillstorm.warehousemanager.services;

import com.skillstorm.warehousemanager.models.WarehouseItem;
import com.skillstorm.warehousemanager.repositories.WarehouseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseItemService {

    private final WarehouseItemRepository warehouseItemRepository;

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

    public WarehouseItem addItem(WarehouseItem item) {
        return warehouseItemRepository.save(item);
    }

    public void updateItem(Long itemId, WarehouseItem newItem) {
        if (warehouseItemRepository.existsById(itemId)) {
            warehouseItemRepository.save(newItem);
        }
    }

    public void deleteItem(Long itemId) {
        warehouseItemRepository.deleteById(itemId);
    }

    public List<WarehouseItem> findItemsByWarehouseAndCompanyName(String warehouseName, String companyName) {
        return warehouseItemRepository.findByWarehouseAndCompanyName(warehouseName, companyName);
    }

    public List<WarehouseItem> findItemsByWarehouseID(Long warehouse_id) {
        return warehouseItemRepository.findWarehouseItemBy(warehouse_id);
    }
}