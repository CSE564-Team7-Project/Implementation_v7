package traffic_management;

import java.util.List;

public class TrafficController {

	public void decideLights(List<Integer> cars, List<TrafficLight> lights, EmergencySignal emergencySignal) {

		// Check for emergency
		if (emergencySignal.isEmergency()) {
			if (emergencySignal.checkCardinal()) {
				// EW bound emergency
				lights.get(0).setColor(Color.GREEN);
				lights.get(1).setColor(Color.RED);
				System.out.println("EMERGENCY: East-West bound");
			} else {
				// NS bound emergency
				lights.get(0).setColor(Color.RED);
				lights.get(1).setColor(Color.GREEN);
				System.out.println("EMERGENCY: North-South bound");
			}
			return;
		}

		//initialize
		if (cars.isEmpty()) {
			lights.get(0).setColor(Color.RED);
			lights.get(1).setColor(Color.RED);
		} else {
			//lane1 & 2 use light1, 3 & 4 use light2
			int cars1 = cars.get(0) + cars.get(1); //lane1 + lane2
			int cars2 = cars.get(2) + cars.get(3); //lane3 + lane4

			if (cars1 >= cars2 + 3 || cars2 == 0) {
				lights.get(0).setColor(Color.GREEN);
				lights.get(1).setColor(Color.RED);
			} else if (cars2 >= cars1 + 3 || cars1 == 0) {
				lights.get(1).setColor(Color.GREEN);
				lights.get(0).setColor(Color.RED);
			} else {
				lights.get(0).setColor(Color.RED);
				lights.get(1).setColor(Color.RED);
			}
		}

	}
}

