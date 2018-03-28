package task1.drawer.impl;

import javafx.scene.shape.Shape;
import task1.entity.Ellipse;
import task1.drawer.Drawer;

public class EllipceDrawerImpl implements Drawer<Ellipse> {

    @Override
    public Shape draw(Ellipse shape) {
        javafx.scene.shape.Ellipse fxEllipse = new javafx.scene.shape.Ellipse(shape.getCenter().getX(), shape.getCenter().getY(),
                shape.getRadiusX(), shape.getRadiusY());
        return fxEllipse;
    }

}
