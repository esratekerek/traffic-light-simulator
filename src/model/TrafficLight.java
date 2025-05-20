package model;

public class TrafficLight {
    private String direction;
    private int greenDuration;
    private final int yellowDuration=3;

    public TrafficLight (String direction) {
        this.direction=direction;
    }
    public String getDirection(){
        return direction;
    }
    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }
    public int getGreenDuration(){
        return greenDuration;
    }
    public int getYellowDuration(){
        return yellowDuration;
    }
    public int getRedDuration(){
        return 120-greenDuration-yellowDuration;
    }
}
