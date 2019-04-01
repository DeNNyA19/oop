package task3.domain;

public class Monitor extends Component {

    private static final long serialVersionUID = -2372623358140438177L;

    private String resolution;
    private String frameRate;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    @Override
    public void buy() {
        System.out.println("You have bought monitor");
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "resolution='" + resolution + '\'' +
                ", frameRate='" + frameRate + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", price=" + price +
                '}';
    }
}
