package delivery.model;

import delivery.constants.DirectionType;

/**
 *
 */

public class Delivery {
    private int x;
    private int y;
    private int direction;
    private int capacity;

    public Delivery(int capacity) {
        this.direction = DirectionType.NORTE.getPosition();
        this.capacity  = capacity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Position (" + getX() + "," + getY() + ") " + "direcion: " + getDirection();
    }
}
