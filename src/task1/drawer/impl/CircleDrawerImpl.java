package task1.drawer.impl;

import javafx.scene.shape.Shape;
import task1.entity.Circle;
import task1.drawer.Drawer;

public class CircleDrawerImpl implements Drawer<Circle> {

    private static final CircleDrawerImpl instance = new CircleDrawerImpl();

    private CircleDrawerImpl() {

    }

    public static CircleDrawerImpl getInstance() {
        return instance;
    }

    @Override
    public Shape draw(Circle shape) {
        javafx.scene.shape.Circle fxCircle = new javafx.scene.shape.Circle(shape.getCenter().getX(),
                shape.getCenter().getY(), shape.getRadius());
        return fxCircle;
    }
}
