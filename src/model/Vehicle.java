package model;

public class Vehicle {
    private String direction;
    private boolean passed;

    public Vehicle(String direction) {
        this.direction = direction;
        this.passed = false;
    }
    public String getDirection() {
        return direction;
    }
    public boolean isPassed() {
        return passed;
    }
    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
