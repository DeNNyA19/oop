package task3.domain;

public class SystemBlock extends Component {

    private static final long serialVersionUID = -2372623358150238177L;

    private String processor;
    private String ram;
    private String gpu;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public void buy() {
        System.out.println("You have bought system block");
    }

    @Override
    public String toString() {
        return "SystemBlock{" +
                "processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", gpu='" + gpu + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", price=" + price +
                '}';
    }
}
