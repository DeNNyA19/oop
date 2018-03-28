package task1.validator;

import task1.entity.Point;
import task1.entity.Triangle;

public class TriangleValidator {

    public static boolean validate(Triangle triangle) {

        Point pointA = triangle.getPointA();
        Point pointB = triangle.getPointB();
        Point pointC = triangle.getPointC();

        return (pointC.getX() - pointA.getX()) / (pointB.getX() - pointA.getX()) !=
                (pointC.getY() - pointA.getY()) / (pointB.getY() - pointA.getY());
    }
}
