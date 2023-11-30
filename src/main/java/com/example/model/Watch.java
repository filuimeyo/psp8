package com.example.model;

import javax.persistence.*;

@Entity
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    @Enumerated(EnumType.STRING)
    private WatchType type;

    private double price;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    // Конструкторы, геттеры и сеттеры

    public Watch() {
        // Пустой конструктор (обязателен для Hibernate)
    }

    public Watch(String brand, WatchType type, double price, int quantity, Manufacturer manufacturer) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public WatchType getType() {
        return type;
    }

    public void setType(WatchType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
