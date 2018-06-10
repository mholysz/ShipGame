package com.ship;

public class Ship {
    private int size;
    private int direction;
    private boolean hit;

    public Ship(int size, int direction, boolean hit) {
        this.size = size;
        this.direction = direction;
        this.hit = hit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
