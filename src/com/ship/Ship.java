package com.ship;

import com.ship.Enums.Direction;

public class Ship {
    private int size;
    private Direction direction;
    private boolean hit;

    public Ship(int size, Direction direction) {
        this.size = size;
        this.direction = direction;
        this.hit = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
