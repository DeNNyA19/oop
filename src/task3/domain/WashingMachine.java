package task3.domain;

import task3.domain.Machine;

public class WashingMachine extends Machine {

    private static final long serialVersionUID = -9061426040701420816L;

    private String capacity;

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}

