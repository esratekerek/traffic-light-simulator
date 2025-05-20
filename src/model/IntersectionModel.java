package model;

public class IntersectionModel {
    private VehicleData vehicleData;
    private TrafficLight northLight,southLight,westLight,eastLight;

    public IntersectionModel(VehicleData vehicleData) {
        this.vehicleData = vehicleData;  // 'vehicleData' atanıyor.

        // Doğru yönleriyle trafik ışıklarını başlatıyoruz:
        this.northLight = new TrafficLight("North");
        this.southLight = new TrafficLight("South");
        this.westLight = new TrafficLight("West");
        this.eastLight = new TrafficLight("East");
    }

    public void calculateGreenDurations(){
        int totalCount=vehicleData.getTotalCount();
        if(totalCount==0)
            totalCount=1;

        northLight.setGreenDuration(calcOran(vehicleData.getNorthCount(),totalCount));
        southLight.setGreenDuration(calcOran(vehicleData.getSouthCount(),totalCount));
        westLight.setGreenDuration(calcOran(vehicleData.getWestCount(),totalCount));
        eastLight.setGreenDuration(vehicleData.getEastCount()/totalCount);
    }
    //calcOran amacı kuzeydeki araç saysı/total araç sayısını bulmak
    //ona göre yeşil süresini ayarlıyor
    private int calcOran(int count, int totalCount){
        double oran=(double) count/totalCount;
        int sure=(int) (oran*120);
        return Math.max(10,Math.min(sure,60));
    }

    public TrafficLight getNorthLight() {
        return northLight;
    }

    public TrafficLight getSouthLight() {
        return southLight;
    }

    public TrafficLight getEastLight() {
        return eastLight;
    }

    public TrafficLight getWestLight() {
        return westLight;
    }

}
