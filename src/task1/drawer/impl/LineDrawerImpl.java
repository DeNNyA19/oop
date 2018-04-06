package task1.drawer.impl;

import javafx.scene.shape.Shape;
import task1.entity.Line;
import task1.drawer.Drawer;

public class LineDrawerImpl implements Drawer<Line> {

    private static final LineDrawerImpl instance = new LineDrawerImpl();

    private LineDrawerImpl() {

    }

    public static LineDrawerImpl getInstance() {
        return instance;
    }

    @Override
    public Shape draw(Line shape) {
        javafx.scene.shape.Line fxLine = new javafx.scene.shape.Line(shape.getPointA().getX(), shape.getPointA().getY(),
                shape.getPointB().getX(), shape.getPointB().getY());
        return fxLine;
    }

}
