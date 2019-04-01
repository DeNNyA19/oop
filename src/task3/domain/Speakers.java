package task3.domain;

public class Speakers extends Component {

    private static final long serialVersionUID = -2373623458146438178L;

    private boolean isWireless;
    private Integer frequenceResponse;
    private Integer number;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    public Integer getFrequenceResponse() {
        return frequenceResponse;
    }

    public void setFrequenceResponse(Integer frequenceResponse) {
        this.frequenceResponse = frequenceResponse;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public void buy() {
        System.out.println("You have bought speakers");
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "isWireless=" + isWireless +
                ", frequenceResponse=" + frequenceResponse +
                ", number=" + number +
                ", serialNumber='" + serialNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", price=" + price +
                '}';
    }
}
