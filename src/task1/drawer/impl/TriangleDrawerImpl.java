package task1.drawer.impl;

import javafx.scene.shape.Polygon;
import task1.entity.Triangle;
import task1.drawer.Drawer;

public class TriangleDrawerImpl implements Drawer<Triangle> {

    private static final TriangleDrawerImpl instance = new TriangleDrawerImpl();

    private TriangleDrawerImpl() {

    }

    public static TriangleDrawerImpl getInstance() {
        return instance;
    }

    @Override
    public javafx.scene.shape.Shape draw(Triangle shape) {
        Polygon fxTriangle = new Polygon();
        Double[] trianglePoints = new Double[] {shape.getPointA().getX(), shape.getPointA().getY(),
                shape.getPointB().getX(), shape.getPointB().getY(),
                shape.getPointC().getX(), shape.getPointC().getY()};
        fxTriangle.getPoints().addAll(trianglePoints);
        return fxTriangle;
    }
}
