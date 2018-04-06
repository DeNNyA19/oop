package task3.domain;

import java.io.Serializable;

/**
 * Base parent class for machine classes hierarchy
 */
public abstract class Machine implements Serializable {

    private static final long serialVersionUID = -1872641596064542849L;

    private String serialNumber;
    private String color;

    public abstract void performWork();

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Machine{"
                + "serialNumber='"
                + serialNumber
                + '\''
                + ", color='"
                + color
                + '\''
                + '}';
    }
}
