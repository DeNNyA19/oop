package task1.drawer;

import task1.entity.Shape;

/**
 * Interface for drawing shapes
 * @param <T> type of shape
 */
public interface Drawer<T extends Shape> {

    /**
     * Method for drawing shapes
     * @param shape shape which should be drown
     * @return Java FX Shape object
     */
    javafx.scene.shape.Shape draw(T shape);

}
