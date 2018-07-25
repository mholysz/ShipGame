package com.ship;

import com.ship.Enums.Direction;

import java.util.ArrayList;

public class Ship {
    private int size;
    private Direction direction;
    private boolean hit;


    public Ship(int size) {
        setSize(size);
        this.hit = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        switch (size){
            case 1:
                this.size = 1;
                break;
            case 2:
                this.size=2;
                break;
            case 3:
                this.size = 3;
                break;
            case 4:
                this.size=4;
                break;
                default:
                    throw new IllegalArgumentException();
        }
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
