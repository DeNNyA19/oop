package task6;

import task3.domain.Machine;
import task4.Plugin;

import java.nio.file.Paths;
import java.util.List;

/**
 * Adapter pattern for plugin from other developer
 */
public class JSONReaderPlugin implements Plugin {

    private final MachinesJSONReader writer = new MachinesJSONReader();

    @Override
    public void execute(List<Machine> machines) {
        writer.read(Paths.get("machines.json"));
    }

    @Override
    public String getDescription() {
        return "JSON Reader";
    }
}
