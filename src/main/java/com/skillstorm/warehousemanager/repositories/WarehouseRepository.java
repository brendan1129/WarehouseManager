package com.skillstorm.warehousemanager.repositories;

import com.skillstorm.warehousemanager.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>
{
    @Query("SELECT w FROM Warehouse w JOIN Company c ON w.company_id = c.company_id WHERE c.companyName = :companyName")
    List<Warehouse> findByCompanyName(String companyName);

    @Query("SELECT w FROM Warehouse w JOIN Company c ON w.company_id = c.company_id WHERE c.company_id = :company_id")
    List<Warehouse> findWarehouseBy(Long company_id);

    Warehouse findByWarehouseName(String warehouseName);

}