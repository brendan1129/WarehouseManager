package com.skillstorm.warehousemanager.controllers;
import com.skillstorm.warehousemanager.models.Company;
import com.skillstorm.warehousemanager.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:5173"}, maxAge = 4800)
@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Map<String, String> requestBody) {
        String companyName = requestBody.get("companyName");
        String companyDescription = requestBody.get("companyDescription");
        Company company = companyService.createCompany(companyName, companyDescription);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byname/{companyName}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String companyName) {
        Company company = companyService.getCompanyByName(companyName);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Void> updateCompany(@PathVariable Long companyId, @RequestBody String newCompanyName) {
        companyService.updateCompany(companyId, newCompanyName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}