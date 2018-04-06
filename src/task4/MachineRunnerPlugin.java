package task4;

import task3.domain.Machine;

import java.util.List;

/**
 * Plugin executes perform work of every machine
 */
public class MachineRunnerPlugin implements Plugin {

    @Override
    public void execute(List<Machine> machines) {
        if (machines == null || machines.isEmpty()) {
            System.out.println("Can perform work. Please add machines");
            return;
        }

        machines.forEach(Machine::performWork);
    }

    @Override
    public String getDescription() {
        return "Perform work";
    }
}
