package task3.domain;

public class Computer extends Machine {

    private static final long serialVersionUID = 5229516636386502604L;

    private String processor;

    public Computer() {}

    public Computer(String processor) {
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Computer{" + "processor='" + processor + '\'' + "} " + super.toString();
    }
}
