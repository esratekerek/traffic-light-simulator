package model;

public class Vehicle {
    private final Direction direction;
    private double position;
    private static final double SPEED = 0.02;

    public Vehicle(Direction direction) {
        this.direction = direction;
        this.position = 0.0;
    }

    public void move() {
        position += SPEED;
    }

    public boolean hasPassedIntersection() {
        return position >= 1.0;
    }

    public double getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}