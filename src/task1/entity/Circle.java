package task1.entity;

import task1.entity.Point;
import task1.entity.Shape;

public class Circle extends Shape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private static Class[] getConstructParams() {
        return new Class[]{Point.class, Double.TYPE};
    }
}
