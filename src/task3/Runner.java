package task3;

import org.apache.commons.lang3.reflect.FieldUtils;
import task3.domain.Machine;
import utils.Utils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {

    private static List<Class> machineClasses;
    private static List<Machine> machines = new ArrayList<>();

    private static Map<Integer, String> actions = new HashMap<>();

    private static Scanner scanner = new Scanner(System.in);

    static {
        Class<Machine> parentClz = Machine.class;

        machineClasses =
                Utils.getClasses("task3.domain")
                        .stream()
                        .filter(clz -> clz.getSuperclass().equals(parentClz))
                        .filter(clz -> !Modifier.isAbstract(clz.getModifiers()))
                        .filter(clz -> !clz.isInterface())
                        .collect(Collectors.toList());

        actions.put(1, "Add machine");
        actions.put(2, "Modify machine");
        actions.put(3, "Remove machine");
        actions.put(4, "View machines");
        actions.put(5, "Serialize machines");
        actions.put(6, "Deserialize machines");
        actions.put(7, "Exit");
    }

    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() throws Exception {
        while (true) {
            System.out.println("\nAvailable actions:");
            actions.forEach((key, value) -> System.out.println(key + ". " + value));

            System.out.println("\nPlease choose one:");

            int actionNum = scanner.nextInt();
            switch (actionNum) {
                case 1:
                    handleAddAction();
                    break;
                case 2:
                    handleModifyAction();
                    break;
                case 3:
                    handleDeleteAction();
                    break;
                case 4:
                    handleViewAction();
                    break;
                case 5:
                    handleSerializeAction("test.bin");
                    break;
                case 6:
                    handleDeserializeAction("test.bin");
                    break;
                case 7:
                    System.out.println("Bye-bye!");
                    return;
                default:
                    System.out.println("Unsupported action");
                    break;
            }
        }
    }

    private static void handleAddAction() throws IllegalAccessException, InstantiationException {
        System.out.println("\nWhich object would you like to add?");
        int num = 0;
        for (Class clz : machineClasses) {
            System.out.println(++num + ". " + clz.getSimpleName());
        }

        int clzNum = scanner.nextInt() - 1;
        Class clz = machineClasses.get(clzNum);

        Machine machine = (Machine) clz.newInstance();
        machines.add(machine);

        while (true) {
            System.out.println(
                    "\nWould you like to fill "
                            + clz.getSimpleName().toLowerCase()
                            + " properties? (y or n)");

            boolean edit = scanner.next().equals("y");
            if (!edit) {
                return;
            }

            modify(machine);
        }
    }

    private static void handleModifyAction() throws IllegalAccessException {
        System.out.println("Which machine would you like to modify?");
        int num = 0;
        for (Machine machine : machines) {
            System.out.println(++num + ". " + machine);
        }

        int objNum = scanner.nextInt() - 1;

        Machine machine = machines.get(objNum);

        while (true) {
            System.out.println(
                    "\nWould you like to fill "
                            + machine.getClass().getSimpleName().toLowerCase()
                            + " properties? (y or n)");

            boolean edit = scanner.next().equals("y");
            if (!edit) {
                return;
            }

            modify(machine);
        }
    }

    private static void handleDeleteAction() {
        System.out.println("Which machine would you like to delete?");
        int num = 0;
        for (Machine machine : machines) {
            System.out.println(++num + ". " + machine);
        }

        int objNum = scanner.nextInt() - 1;
        machines.remove(objNum);
    }

    private static void handleViewAction() {
        if (machines.isEmpty()) {
            System.out.println("No machines :(");
            return;
        }
        System.out.println("\nMachines:");
        machines.forEach(System.out::println);
    }

    private static void handleSerializeAction(String fileName) throws IOException {
        serialize(new File(fileName), machines);
        System.out.println("Machines have been serialized");
    }

    private static void handleDeserializeAction(String fileName)
            throws IOException, ClassNotFoundException {
        List<Machine> deserialized = deserialize(new File(fileName));
        System.out.println("\nDeserialized machines:");
        deserialized.forEach(System.out::println);
    }

    private static void serialize(File file, List<Machine> machines) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Machine machine : machines) {
                oos.writeObject(machine);
            }
        }
    }

    private static List<Machine> deserialize(File file) throws IOException, ClassNotFoundException {
        List<Machine> machines = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // FIXME
            try {
                while (true) {
                    machines.add((Machine) ois.readObject());
                }
            } catch (EOFException ex) {
                return machines;
            }
        }
    }

    private static void modify(Machine machine) throws IllegalAccessException {
        Class<? extends Machine> clz = machine.getClass();
        List<Field> fields =
                FieldUtils.getAllFieldsList(clz)
                        .stream()
                        .filter(field -> !Modifier.isStatic(field.getModifiers()))
                        .collect(Collectors.toList());

        fields.forEach(field -> field.setAccessible(true));

        System.out.println('\n' + clz.getSimpleName().toLowerCase() + " properties:");
        int num = 0;
        for (Field field : fields) {
            System.out.println(++num + ". " + field.getName());
        }

        System.out.println("\nWhich property would you like to edit?");

        int fieldNum = scanner.nextInt() - 1;
        Field field = fields.get(fieldNum);

        System.out.println("Please type value:");

        Class<?> type = field.getType();

        Object value;
        if (type.equals(Double.TYPE)) {
            value = scanner.nextDouble();
        } else if (type.equals(Integer.TYPE)) {
            value = scanner.nextInt();
        } else if (type.equals(Boolean.TYPE)) {
            value = scanner.nextBoolean();
        } else {
            value = scanner.next();
        }

        field.set(machine, value);

        System.out.println("\nProperty has been modified");
        System.out.println(machine);
    }
}
