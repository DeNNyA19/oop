package task4;

import task3.domain.Machine;

import java.util.List;

public interface Plugin {

    void execute(List<Machine> machines);

    String getDescription();
}
