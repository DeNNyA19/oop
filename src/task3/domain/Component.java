package task3.domain;

import java.io.Serializable;

/**
 * Base parent class for machine classes hierarchy
 */
public abstract class Component implements Serializable {

    private static final long serialVersionUID = -1872641596064542849L;

    protected String serialNumber;
    protected String originCountry;
    protected String price;

    public abstract void buy();

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
