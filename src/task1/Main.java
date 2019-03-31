package task1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import task1.entity.*;

public class Main extends Application {

    public static final ShapeList STATIC_SHAPE_LIST;

    static {
        STATIC_SHAPE_LIST = new ShapeList();
        STATIC_SHAPE_LIST.add(new Circle(new Point(100, 100), 50));
        STATIC_SHAPE_LIST.add(new Square(new Point(200, 100), 30));
        STATIC_SHAPE_LIST.add(new Line(new Point(1000, 300), new Point(1100, 400)));
        STATIC_SHAPE_LIST.add(new Triangle(new Point(400, 300), new Point(500, 320), new Point(360, 270)));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1400, 820));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
