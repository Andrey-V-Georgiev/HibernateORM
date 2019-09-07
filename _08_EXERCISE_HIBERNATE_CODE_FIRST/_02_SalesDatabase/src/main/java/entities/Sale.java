package entities;

import java.util.Date;

public class Sale extends BaseEntity{
    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private Date date;

    public Sale() {
    }

    public Sale(int id, Product product, Customer customer, StoreLocation storeLocation, Date date) {
        super(id);
        this.product = product;
        this.customer = customer;
        this.storeLocation = storeLocation;
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
