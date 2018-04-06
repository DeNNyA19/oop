package task1.drawer.impl;

import task1.entity.Rectangle;
import task1.drawer.Drawer;

public class RectangleDrawerImpl implements Drawer<Rectangle> {

    private static final RectangleDrawerImpl instance = new RectangleDrawerImpl();

    private RectangleDrawerImpl() {

    }

    public static RectangleDrawerImpl getInstance() {
        return instance;
    }

    @Override
    public javafx.scene.shape.Shape draw(Rectangle shape) {
        javafx.scene.shape.Rectangle fxRectangle = new javafx.scene.shape.Rectangle(shape.getPointA().getX(),
                shape.getPointA().getY(), shape.getWidth(), shape.getHeight());
        return fxRectangle;
    }
}
