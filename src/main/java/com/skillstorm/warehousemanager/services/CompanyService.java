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

    public Company createCompany(String companyName, String companyDescription) {
        Company exisitingCompany = companyRepository.findByCompanyName(companyName);
        if(exisitingCompany != null) {
            throw new IllegalArgumentException("Company with the same name already exists");
        }
        Company company = new Company(companyName, companyDescription);
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

    // Other business logic and operations
    public void deleteCompany(Long companyID) { companyRepository.deleteById(companyID); }
}