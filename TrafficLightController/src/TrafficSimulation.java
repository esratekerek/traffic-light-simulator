package model;

import controller.TrafficLightController;
import java.util.*;

public class TrafficSimulation {
    private final Map<Direction, List<Vehicle>> vehiclesByDirection;
    private final TrafficLightController controller;

    public TrafficSimulation(TrafficLightController controller) {
        this.controller = controller;
        this.vehiclesByDirection = new EnumMap<>(Direction.class);

        for (Direction dir : Direction.values()) {
            vehiclesByDirection.put(dir, new ArrayList<>());
        }
    }

    public void spawnVehicles(Direction dir, int count) {
        List<Vehicle> vehicles = vehiclesByDirection.get(dir);
        for (int i = 0; i < count; i++) {
            vehicles.add(new Vehicle(dir));
        }
    }

    public void updateSimulation() {
        vehiclesByDirection.forEach((direction, vehicles) -> {
            Iterator<Vehicle> iterator = vehicles.iterator();
            while (iterator.hasNext()) {
                Vehicle vehicle = iterator.next();
                if (controller.isMovementAllowed(direction)) {
                    vehicle.move();
                }
                if (vehicle.hasPassedIntersection()) {
                    iterator.remove();
                }
            }
        });
    }

    public Map<Direction, List<Vehicle>> getVehicles() {
        return Collections.unmodifiableMap(vehiclesByDirection);
    }
}