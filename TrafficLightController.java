package controller;

import model.Direction;
import java.util.EnumMap;
import java.util.Map;

public class TrafficLightController {
    private final Map<Direction, Integer> greenLightDurations = new EnumMap<>(Direction.class);
    private final Map<Direction, Boolean> movementPermissions = new EnumMap<>(Direction.class);

    private static final int TOTAL_CYCLE_TIME = 120;
    private static final int MIN_GREEN_TIME = 10;
    private static final int MAX_GREEN_TIME = 60;

    public TrafficLightController() {
        for (Direction dir : Direction.values()) {
            movementPermissions.put(dir, false); // Başlangıçta tüm yönler kapalı
        }
    }

    public void calculateGreenTimes(Map<Direction, Integer> vehicleCounts) {
        int totalVehicles = vehicleCounts.values().stream().mapToInt(i -> i).sum();

        vehicleCounts.forEach((direction, count) -> {
            double ratio = totalVehicles > 0 ? (double) count / totalVehicles : 0.25;
            int greenTime = (int) (TOTAL_CYCLE_TIME * ratio);
            greenTime = Math.max(MIN_GREEN_TIME, Math.min(MAX_GREEN_TIME, greenTime));
            greenLightDurations.put(direction, greenTime);

            // TEST AMAÇLI: Tüm yönlere geçici izin ver
            movementPermissions.put(direction, true);
        });
    }

    public boolean isMovementAllowed(Direction direction) {
        return movementPermissions.getOrDefault(direction, false);
    }

    public int getGreenTime(Direction direction) {
        return greenLightDurations.getOrDefault(direction, 0);
    }
}