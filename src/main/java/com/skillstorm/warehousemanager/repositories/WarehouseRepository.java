package com.skillstorm.warehousemanager.repositories;

import com.skillstorm.warehousemanager.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>
{
    @Query("SELECT w FROM Warehouse w JOIN Company c ON w.company_id = c.company_id WHERE c.companyName = :companyName")
    List<Warehouse> findByCompanyName(String companyName);
}