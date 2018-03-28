package task3.domain;

public class Car extends Machine {

    private static final long serialVersionUID = 8004949830156881967L;

    private String fuelType;

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Car{" + "fuelType='" + fuelType + '\'' + "} " + super.toString();
    }
}
