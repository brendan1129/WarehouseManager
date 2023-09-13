package com.skillstorm.warehousemanager.services;

import com.skillstorm.warehousemanager.models.Company;
import com.skillstorm.warehousemanager.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(String companyName) {
        Company company = new Company(companyName);
        return companyRepository.save(company);
    }
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    public Company getCompanyById(Long companyID) {
        return companyRepository.findById(companyID).orElse(null);
    }

    public Company getCompanyByName(String companyName) {
        return companyRepository.findByCompanyName(companyName);
    }
    public void updateCompany(Long companyID, String newCompanyName) {
        Company existingCompany = companyRepository.findById(companyID).orElse(null);
        if (existingCompany != null) {
            existingCompany.setCompanyName(newCompanyName);
            companyRepository.save(existingCompany);
        }
    }

    public void deleteCompany(Long companyID) {
        companyRepository.deleteById(companyID);
    }
    // Other business logic and operations
}