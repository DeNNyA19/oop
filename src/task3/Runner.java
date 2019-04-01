package task3;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.reflections.Reflections;
import task3.domain.Component;
import task4.Plugin;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {

    private static List<Class> componentClasses;
    //components list
    private static List<Component> components = new ArrayList<>();

    private static Map<Integer, String> actions = new HashMap<>();
    // private static Map<Integer, Plugin> plugins = new HashMap<>();

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Plugin> plugins = new HashMap<>();

    static {
        componentClasses = new ArrayList<>(new Reflections().getSubTypesOf(Component.class));

        actions.put(1, "Add component");
        actions.put(2, "Modify component");
        actions.put(3, "Remove component");
        actions.put(4, "View components");
        actions.put(5, "Serialize components");
        actions.put(6, "Deserialize components");
        actions.put(7, "Exit");


        //Loading all classes from classpath that implements Plugin interface
        for (Plugin plugin : ServiceLoader.load(Plugin.class)) {
            plugins.put(actions.size() + plugins.size() + 1, plugin);
        }
    }

    public static void main(String[] args) throws Exception {
        // user interface
        while (true) {
            System.out.println("///////Menu///////");
            System.out.println("\nAvailable actions:");
            actions.forEach((key, value) -> System.out.println(key + ". " + value));

            System.out.println("\nAvailable plugins:");
            plugins.forEach(
                    (key, value) -> System.out.println(key + ". " + value.getDescription()));

            System.out.println("\nPlease choose one:");
            System.out.println("//////Choose///////");

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
                    handleSerializeAction();
                    break;
                case 6:
                    handleDeserializeAction();
                    break;
                case 7:
                    System.out.println("Bye-bye!");
                    return;
                default:
                    Plugin plugin = plugins.get(actionNum);
                    if (plugin != null) {
                        plugin.execute(components);
                        break;
                    }

                    System.out.println("Unsupported action");
                    break;
            }
        }
    }

    /**
     * Method adds Component children object
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void handleAddAction() throws IllegalAccessException, InstantiationException {
        System.out.println("\nWhich object would you like to add?");
        int num = 0;
        for (Class clz : componentClasses) {
            System.out.println(++num + ". " + clz.getSimpleName());
        }

        int clzNum = scanner.nextInt() - 1;
        Class clz = componentClasses.get(clzNum);

        Component component = (Component) clz.newInstance();
        components.add(component);

        while (true) {
            System.out.println(
                    "\nWould you like to fill "
                            + clz.getSimpleName().toLowerCase()
                            + " properties? (y or n)");

            boolean edit = scanner.next().equals("y");
            if (!edit) {
                return;
            }

            modify(component);
        }
    }

    /**
     * Method modifies Component sub object
     *
     * @throws IllegalAccessException
     */
    private static void handleModifyAction() throws IllegalAccessException {
        System.out.println("Which component would you like to modify?");
        int num = 0;
        for (Component component : components) {
            System.out.println(++num + ". " + component);
        }

        int objNum = scanner.nextInt() - 1;

        Component component = components.get(objNum);

        while (true) {
            System.out.println(
                    "\nWould you like to fill "
                            + component.getClass().getSimpleName().toLowerCase()
                            + " properties? (y or n)");

            boolean edit = scanner.next().equals("y");
            if (!edit) {
                return;
            }

            modify(component);
        }
    }

    /**
     * Method deletes component object from components list
     */
    private static void handleDeleteAction() {
        System.out.println("Which component would you like to delete?");
        int num = 0;
        for (Component component : components) {
            System.out.println(++num + ". " + component);
        }

        int objNum = scanner.nextInt() - 1;
        components.remove(objNum);
    }

    private static void handleViewAction() {
        if (components.isEmpty()) {
            System.out.println("No components :(");
            return;
        }
        System.out.println("\ncomponents:");
        components.forEach(System.out::println);
    }

    private static void handleSerializeAction() throws IOException {
        System.out.println("\nEnter the name of serialization file:");
        String fileName = scanner.next();
        serialize(new File(fileName), components);
        System.out.println("components have been serialized");
    }

    private static void handleDeserializeAction()
            throws IOException, ClassNotFoundException {
        System.out.println("\nEnter the name of serialization file:");
        String fileName = scanner.next();
        List<Component> deserialized = deserialize(new File(fileName));
        System.out.println("\nDeserialized components:");
        deserialized.forEach(System.out::println);
    }

    /**
     * Method serializing components to binary to selected file
     *
     * @param file       selected file
     * @param components components for serialization
     * @throws IOException
     */
    private static void serialize(File file, List<Component> components) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Component component : components) {
                oos.writeObject(component);
            }
        }
    }

    /**
     * Method deserializing components from selected file
     *
     * @param file selected file
     * @return list of components
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static List<Component> deserialize(File file) throws IOException, ClassNotFoundException {
        List<Component> components = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            try {
                while (true) {
                    components.add((Component) ois.readObject());
                }
            } catch (EOFException ex) {
                return components;
            }
        }
    }

    /**
     * Method shows all params of class and modifies param of object
     *
     * @param component selected component subclass
     * @throws IllegalAccessException
     */
    private static void modify(Component component) throws IllegalAccessException {
        Class<? extends Component> clz = component.getClass();
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

        field.set(component, value);

        System.out.println("\nProperty has been modified");
        System.out.println(component);
    }
}
