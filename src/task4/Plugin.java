package task4;

import task3.domain.Machine;

import java.util.List;

/**
 * Common interface for plugins
 */
public interface Plugin {

    void execute(List<Machine> machines);

    String getDescription();
}
