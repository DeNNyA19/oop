package task1.drawer.impl;

import javafx.scene.shape.Shape;
import task1.entity.Square;
import task1.drawer.Drawer;

public class SquareDrawerImpl implements Drawer<Square> {
    @Override
    public Shape draw(Square shape) {
        javafx.scene.shape.Rectangle fxRectangle = new javafx.scene.shape.Rectangle(shape.getPointA().getX(),
                shape.getPointA().getY(), shape.getWidth(), shape.getWidth());
        return fxRectangle;
    }
}
