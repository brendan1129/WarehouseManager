package com.skillstorm.warehousemanager.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Entity
@Component
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
    private Long warehouse_id;

    @Column(name = "price", nullable = false)
    @Setter
    private BigDecimal price;
    // Constructors, getters, and setters
    // Constructors
    public WarehouseItem() {
    }

    public WarehouseItem(String itemName, Integer quantity, Long warehouse_id, BigDecimal price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.warehouse_id = warehouse_id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "WarehouseItem{" +
                "item_id=" + item_id +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", warehouseID=" + warehouse_id +
                ", price=" + price +
                '}';
    }
}