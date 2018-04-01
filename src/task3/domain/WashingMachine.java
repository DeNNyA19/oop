package task3.domain;

public class WashingMachine extends Machine {

    private static final long serialVersionUID = -9061426040701420816L;

    private String capacity;

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public void performWork() {
        System.out.println("Wash");
    }

    @Override
    public String toString() {
        return "WashingMachine{" + "capacity='" + capacity + '\'' + "} " + super.toString();
    }
}
