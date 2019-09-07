package entities;

import java.util.Set;

public class StoreLocation extends BaseEntity{
    private String locationName;
    private Set<Sale> sales;

    public StoreLocation() {
    }

    public StoreLocation(int id, String locationName, Set<Sale> sales) {
        super(id);
        this.locationName = locationName;
        this.sales = sales;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
