package com.skillstorm.warehousemanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "company")
public class Company {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`companyID`")
    private Long companyID;
    @Setter
    @Column(name = "`companyName`", nullable = false)
    private String companyName;

    @Setter
    @Column(name = "`companyDescription`")
    private String companyDescription;
    // Constructors, getters, and setters

    public Company() {
        // Default constructor
    }

    public Company(String companyName, String companyDescription) {
        this.companyName = companyName;
        this.companyDescription = companyDescription;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                '}';
    }
}