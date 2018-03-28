package task3.domain;

public class CoffeMachine extends Machine {

    private static final long serialVersionUID = 6943981680884360595L;

    private double capacity;
    private double energyConsumption;

    public CoffeMachine() {}

    public CoffeMachine(double capacity, double energyConsumption) {
        this.capacity = capacity;
        this.energyConsumption = energyConsumption;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    @Override
    public String toString() {
        return "CoffeMachine{"
                + "capacity="
                + capacity
                + ", energyConsumption="
                + energyConsumption
                + '}';
    }
}
