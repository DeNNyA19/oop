package task1.drawer;

import task1.entity.Shape;

public interface Drawer<T extends Shape> {

    javafx.scene.shape.Shape draw(T shape);

}
