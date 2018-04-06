package task1.drawer;

import task1.entity.*;
import task1.drawer.impl.*;

import java.util.HashMap;
import java.util.Map;

public class DrawerFactory {

    private static final Map<Class<? extends Shape>, Drawer<? extends Shape>> drawers = new HashMap<>();

    static {
        drawers.put(Rectangle.class, RectangleDrawerImpl.getInstance());
        drawers.put(Triangle.class, TriangleDrawerImpl.getInstance());
        drawers.put(Circle.class, CircleDrawerImpl.getInstance());
        drawers.put(Square.class, SquareDrawerImpl.getInstance());
        drawers.put(Line.class, LineDrawerImpl.getInstance());
        drawers.put(Ellipse.class, EllipseDrawerImpl.getInstance());
    }

    public static <T extends Shape> Drawer<T> get(Class<T> clz) {
        return (Drawer<T>) drawers.get(clz);
    }

}
