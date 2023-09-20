package com.skillstorm.warehousemanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "warehouse-item", schema = "public")

public class WarehouseItem {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer item_id;

    @Column(name = "`itemName`", nullable = false)
    @Setter
    private String itemName;

    @Column(name = "quantity", nullable = false)
    @Setter
    private Integer quantity;

    @Column(name = "warehouse_id", nullable = false)
    @Setter
    private Integer warehouse_id;
    // Constructors, getters, and setters

    // Constructors
    public WarehouseItem() {
    }

    public WarehouseItem(String itemName, Integer quantity, Integer warehouse_id) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.warehouse_id = warehouse_id;
    }

    @Override
    public String toString() {
        return "WarehouseItem{" +
                "item_id=" + item_id +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", warehouseID=" + warehouse_id +
                '}';
    }
}