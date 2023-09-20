package com.skillstorm.warehousemanager.repositories;

import com.skillstorm.warehousemanager.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // You can define custom query methods here if needed

    // Example: Find a company by its name
    Company findByCompanyName(String companyName);

}