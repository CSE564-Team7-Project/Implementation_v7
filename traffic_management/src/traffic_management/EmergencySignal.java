package traffic_management;

import java.util.Random;

public class EmergencySignal {
    // Simulate 35% chance of emergency vehicle
    // To do this, we use only one camera to simulate a true 35% chance
    Camera camera = new Camera();

    public boolean isEmergency() {
        if (camera.getEmergency() <= 30) {
            return true;
        } else {
            return false;
        }
    }

    // Cardinal denotes emergency vehicle is NS bound
    public boolean checkCardinal() {
        Random randCardinal = new Random();

        if (randCardinal.nextInt(2) % 2 == 0) {
            return false;
        }

        return true;
    }
}
