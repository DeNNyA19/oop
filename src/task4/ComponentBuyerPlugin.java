package task4;

import task3.domain.Component;

import java.util.List;

/**
 * Plugin buys component
 */
public class ComponentBuyerPlugin implements Plugin {

    @Override
    public void execute(List<Component> components) {
        if (components == null || components.isEmpty()) {
            System.out.println("Can perform work. Please add components");
            return;
        }

        components.forEach(Component::buy);
    }

    @Override
    public String getDescription() {
        return "Buys components";
    }
}
