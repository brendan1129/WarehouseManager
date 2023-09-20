package com.skillstorm.warehousemanager.repositories;

import com.skillstorm.warehousemanager.models.WarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseItemRepository extends JpaRepository<WarehouseItem, Long> {

    @Query("SELECT wi FROM Warehouse w JOIN Company c ON w.company_id = c.company_id JOIN WarehouseItem wi ON w.warehouse_id = wi.warehouse_id WHERE c.companyName = :companyName AND w.warehouseName = :warehouseName")
    List<WarehouseItem> findByWarehouseAndCompanyName(String warehouseName, String companyName);

    @Query("SELECT wi FROM Warehouse w JOIN WarehouseItem wi ON w.warehouse_id = wi.warehouse_id WHERE w.warehouse_id = :warehouse_id")
    List<WarehouseItem> findWarehouseItemBy(Long warehouse_id);
}
