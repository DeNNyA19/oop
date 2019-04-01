package task3.domain;

public class CopyMachine extends Component {

    private static final long serialVersionUID = -2271623348130438177L;

    private String inkType;
    private Integer slotSize;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getInkType() {
        return inkType;
    }

    public void setInkType(String inkType) {
        this.inkType = inkType;
    }

    public Integer getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(Integer slotSize) {
        this.slotSize = slotSize;
    }

    @Override
    public void buy() {
        System.out.println("You have bought copy machine");
    }

    @Override
    public String toString() {
        return "CopyMachine{" +
                "inkType='" + inkType + '\'' +
                ", slotSize=" + slotSize +
                ", serialNumber='" + serialNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", price=" + price +
                '}';
    }
}
