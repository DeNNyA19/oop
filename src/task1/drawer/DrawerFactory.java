package task1.drawer;

import task1.entity.*;
import task1.drawer.Drawer;
import task1.drawer.impl.*;

import java.util.HashMap;
import java.util.Map;

public class DrawerFactory {

    private static final Map<Class<? extends Shape>, Drawer<? extends Shape>> drawers = new HashMap<>();

    static {
        drawers.put(Rectangle.class, new RectangleDrawerImpl());
        drawers.put(Triangle.class, new TriangleDrawerImpl());
        drawers.put(Circle.class, new CircleDrawerImpl());
        drawers.put(Square.class, new SquareDrawerImpl());
        drawers.put(Line.class, new LineDrawerImpl());
        drawers.put(Ellipse.class, new EllipceDrawerImpl());
    }

    public static <T extends Shape> Drawer<T> get(Class<T> clz) {
        return (Drawer<T>) drawers.get(clz);
    }

}
