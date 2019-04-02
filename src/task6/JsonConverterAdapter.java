package task6;

import task3.domain.Component;
import task4.Plugin;

import java.util.List;

public class JsonConverterAdapter implements Plugin {

    @Override
    public void execute(List<Component> components) {
        new JsonConverter().convert(components);
    }

    @Override
    public String getDescription() {
        return "Json converter";
    }
}
