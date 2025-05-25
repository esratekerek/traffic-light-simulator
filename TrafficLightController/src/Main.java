import controller.TrafficLightController;
import model.Direction;
import model.TrafficSimulation;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Controller ve Simulation oluştur
        TrafficLightController controller = new TrafficLightController();
        TrafficSimulation simulation = new TrafficSimulation(controller);

        // 2. Test verilerini hazırla
        Map<Direction, Integer> testData = Map.of(
                Direction.NORTH, 10,
                Direction.SOUTH, 5,
                Direction.EAST, 3,
                Direction.WEST, 2
        );

        // 3. Işık sürelerini hesapla
        controller.calculateGreenTimes(testData);

        // 4. Araçları ekle
        simulation.spawnVehicles(Direction.NORTH, 3);
        simulation.spawnVehicles(Direction.SOUTH, 2);

        // 5. Simülasyonu çalıştır
        for (int i = 0; i < 10; i++) {
            simulation.updateSimulation();

            System.out.println("\n--- Adım " + i + " ---");
            System.out.println("Kuzeydeki araçlar: " +
                    simulation.getVehicles().get(Direction.NORTH).size());
            System.out.println("Güneydeki araçlar: " +
                    simulation.getVehicles().get(Direction.SOUTH).size());
        }
    }
}