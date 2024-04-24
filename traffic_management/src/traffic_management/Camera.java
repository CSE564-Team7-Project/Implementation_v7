package traffic_management;

import java.util.Random;

public class Camera {
    public int getEmergency() {
        // Simulate a random number
        Random random = new Random();
        return random.nextInt(101);
    }
}