package task1;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import task1.drawer.Drawer;
import task1.drawer.DrawerFactory;
import task1.entity.*;
import utils.Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    @FXML public AnchorPane base;

    @FXML public ComboBox<String> dropDown;

    @FXML public VBox inputContainer;

    private Map<String, Class> shapeMap = new HashMap<>();

    private List<TextField> paramFields = new ArrayList<>();

    @FXML
    public void initialize()
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException,
                    InstantiationException {
        Circle circle1 = new Circle(new Point(100, 100), 50d);
        Rectangle rectangle1 = new Rectangle(new Point(200, 200), 30d, 70d);
        Square square1 = new Square(new Point(300, 300), 66d);
        Triangle triangle1 =
                new Triangle(new Point(400, 400), new Point(600, 500), new Point(600, 400));
        Line line1 = new Line(new Point(0, 0), new Point(100, 100));
        Ellipse ellipse1 = new Ellipse(new Point(600, 100), 50d, 100d);

        Circle circle2 = new Circle(new Point(600, 100), 50d);
        Rectangle rectangle2 = new Rectangle(new Point(500, 200), 30d, 70d);
        Square square2 = new Square(new Point(500, 300), 66d);
        Triangle triangle2 =
                new Triangle(new Point(500, 500), new Point(700, 600), new Point(700, 500));

        ShapeList shapeList = new ShapeList();
        shapeList.add(rectangle1);
        shapeList.add(circle1);
        shapeList.add(triangle1);
        shapeList.add(square1);
        shapeList.add(rectangle2);
        shapeList.add(circle2);
        shapeList.add(triangle2);
        shapeList.add(square2);
        shapeList.add(line1);
        shapeList.add(ellipse1);

        for (int i = 0; i < shapeList.size(); i++) {
            Shape shape = shapeList.get(i);
            if (shape != null) {
                Drawer drawer = DrawerFactory.get(shape.getClass());
                base.getChildren().add(drawer.draw(shape));
            }
        }

        // Combo box
        List<Class> shapeClasses = Utils.getClasses("task1.entity.shape");

        shapeMap =
                shapeClasses.stream().collect(Collectors.toMap(Class::getSimpleName, clz -> clz));

        dropDown.getItems().addAll(shapeMap.keySet());
    }

    @FXML
    public void dropDownOnClick()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ObservableList<Node> children = inputContainer.getChildren();

        Class<? extends Shape> shapeClass = shapeMap.get(dropDown.getValue());
        Class[] params = getParams(shapeClass);

        children.clear();
        paramFields = new ArrayList<>();

        for (Class param : params) {
            if (param.equals(Point.class)) {
                children.add(new Label("Point (x,y):"));

                TextField x = new TextField();
                TextField y = new TextField();

                children.add(x);
                children.add(y);

                paramFields.add(x);
                paramFields.add(y);

            } else if (param.equals(Double.TYPE)) {
                children.add(new Label("Line (x)"));
                TextField x = new TextField();
                children.add(x);

                paramFields.add(x);
            }
        }
    }

    @FXML
    public void addShapeOnClick()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
                    InstantiationException {
        String shapeName = dropDown.getValue();
        Class<? extends Shape> shapeClass = shapeMap.get(shapeName);
        Class[] paramClasses = getParams(shapeClass);
        Constructor<? extends Shape> constructor = shapeClass.getConstructor(paramClasses);

        Queue<Double> values =
                paramFields
                        .stream()
                        .map(TextInputControl::getText)
                        .map(Double::parseDouble)
                        .collect(Collectors.toCollection(LinkedList::new));

        Object[] params = new Object[paramClasses.length];

        for (int i = 0; i < paramClasses.length; i++) {
            Class paramClass = paramClasses[i];
            if (paramClass.equals(Point.class)) {
                params[i] = new Point(values.poll(), values.poll());
            } else if (paramClass.equals(Double.TYPE)) {
                params[i] = values.poll();
            }
        }

        Shape shape = constructor.newInstance(params);

        Drawer drawer = DrawerFactory.get(shape.getClass());
        base.getChildren().add(drawer.draw(shape));
    }

    private Class[] getParams(Class shapeClass)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method getConstructParams = shapeClass.getDeclaredMethod("getConstructParams");
        getConstructParams.setAccessible(true);
        return (Class[]) getConstructParams.invoke(null);
    }
}
