package com.skillstorm.warehousemanager.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "warehouse", schema = "public")
public class Warehouse {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Integer warehouse_id;

    @Setter
    @Column(name = "`warehouseName`", nullable = false)
    private String warehouseName;

    @Setter
    @Column(name = "company_id", nullable = false)
    private Integer company_id;

    @Setter
    @Column(name = "`maxCapacity`", nullable = false)
    private Integer maxCapacity;

    // Constructors, getters, and setters

    public Warehouse() {
        // Default constructor
    }

    public Warehouse(String warehouseName, Integer company_id, Integer maxCapacity) {
        this.warehouseName = warehouseName;
        this.company_id = company_id;
        this.maxCapacity = maxCapacity;
    }

    // toString() method

    @Override
    public String toString() {
        return "Warehouse{" +
                "company_id=" + warehouse_id +
                ", warehouseName='" + warehouseName + '\'' +
                ", company_id=" + company_id +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}

