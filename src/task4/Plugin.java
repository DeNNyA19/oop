package task4;

import task3.domain.Component;

import java.util.List;

/**
 * Common interface for plugins
 */
public interface Plugin {

    void execute(List<Component> components);

    String getDescription();
}
