package task3.domain;

public class Keyboard extends Component {

    private static final long serialVersionUID = 5229516636386502604L;

    private String size;
    private boolean isWireless;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    @Override
    public void buy() {
        System.out.println("You have bought keyboard");
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "size='" + size + '\'' +
                ", isWireless=" + isWireless +
                ", serialNumber='" + serialNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", price=" + price +
                '}';
    }
}
