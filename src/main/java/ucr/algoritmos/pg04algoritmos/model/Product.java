package ucr.algoritmos.pg04algoritmos.model;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private String type;
    private LocalDate registerDate;

    public Product(int id, String name, double price, int stock, String type, LocalDate registerDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", type='" + type + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
