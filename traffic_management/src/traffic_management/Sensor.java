package traffic_management;

import java.util.Random;

public class Sensor {
    Random rand = new Random();

    // Simulating the number of cars approaching the intersection at a single lane
    public int getNumberOfCars() {
        return rand.nextInt(6);
    }
}
