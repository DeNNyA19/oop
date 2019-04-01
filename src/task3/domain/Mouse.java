package task3.domain;

public class Mouse extends Component {

    private static final long serialVersionUID = -2373623458140438177L;

    private boolean isWireless;
    private Integer dpi;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    @Override
    public void buy() {
        System.out.println("You have bought mouse");
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "isWireless=" + isWireless +
                ", dpi=" + dpi +
                ", serialNumber='" + serialNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", price=" + price +
                '}';
    }
}
