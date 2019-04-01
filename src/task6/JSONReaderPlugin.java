package task6;

import task3.domain.Component;
import task4.Plugin;

import java.nio.file.Paths;
import java.util.List;

/**
 * Adapter pattern for plugin from other developer
 */
public class JSONReaderPlugin implements Plugin {

    private final MachinesJSONReader writer = new MachinesJSONReader();


    @Override
    public void execute(List<Component> components) {
        writer.read(Paths.get("components.json"));
    }

    @Override
    public String getDescription() {
        return "JSON Reader";
    }
}
