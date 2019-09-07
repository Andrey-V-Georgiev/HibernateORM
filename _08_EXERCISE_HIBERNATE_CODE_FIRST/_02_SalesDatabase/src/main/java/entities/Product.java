package entities;

import java.math.BigDecimal;
import java.util.Set;

public class Product extends BaseEntity{
    private String name;
    private Double quantity;
    private BigDecimal price;
    private Set<Sale> sales;

    public Product() {
    }

    public Product(int id, String name, Double quantity, BigDecimal price, Set<Sale> sales) {
        super(id);
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
