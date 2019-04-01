package task4;

import task3.domain.Component;

public class Joystick extends Component {

    private static final long serialVersionUID = -2273423458140438177L;

    private boolean isWireless;
    private String color;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void buy() {
        System.out.println("You have bought joystick");
    }

    @Override
    public String toString() {
        return "Joystick{" +
                "isWireless=" + isWireless +
                ", color='" + color + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
