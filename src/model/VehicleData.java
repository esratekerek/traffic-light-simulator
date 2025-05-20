package model;

public class VehicleData {
    private int northCount;
    private int southCount;
    private int eastCount;
    private int westCount;

    public VehicleData() {};

    public VehicleData(int northCount, int southCount, int eastCount, int westCount) {
        this.northCount = northCount;
        this.southCount = southCount;
        this.eastCount = eastCount;
        this.westCount = westCount;
    }

    public int getNorthCount() {
        return northCount;
    }
    public void setNorthCount(int northCount) {
        this.northCount = northCount;
    }

    public int getSouthCount() {
        return southCount;
    }
    public void setSouthCount(int southCount) {
        this.southCount = southCount;
    }

    public int getEastCount() {
        return eastCount;
    }
    public void setEastCount(int eastCount) {
        this.eastCount = eastCount;
    }

    public int getWestCount() {
        return westCount;
    }
    public void setWestCount(int westCount) {
        this.westCount = westCount;
    }

    public int getTotalCount() {
        return northCount + southCount + eastCount + westCount;
    }
}
