package traffic_management;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// declare components
		TrafficController tc = new TrafficController(); // main trafficController
		DirectionControl westeastDC = new DirectionControl(); // directionControl for lane1&2
		DirectionControl northsouthDC = new DirectionControl(); // directionControl for lane3&4
		TrafficLight westeastLight = new TrafficLight(); // TrafficLight for lane1&2
		TrafficLight northsouthLight = new TrafficLight(); // TrafficLight for lane3&4

		Road roadWest = new Road();
		Road roadEast = new Road();
		Road roadNorth = new Road();
		Road roadSouth = new Road();

		// create list of each lane's car number: cars.get(0) = lane1, cars.get(1) = lane2....
		List<Integer> cars = new ArrayList<>();

		// create list of two lights: lights.get(0) = lane1&2, lights.get(1) = lane3&4
		List<TrafficLight> lights = new ArrayList<>();
		lights.add(westeastLight); // initialize = red
		lights.add(northsouthLight); // initialize = red

		// Create an instance of EmergencySignal
		EmergencySignal emergencySignal = new EmergencySignal();

		for (int i = 0; i < lights.size(); i++) {
			System.out.println(lights.get(i).getColor());
		}

		// initialize each lane's car number
		int laneWestNum = roadWest.getCarNum();
		int laneEastNum = roadEast.getCarNum();
		int laneNorthNum = roadNorth.getCarNum();
		int laneSouthNum = roadSouth.getCarNum();

		// 100 rounds
		for (int i = 0; i < 50; i++) {
			System.out.println("======= ROUND " + (i + 1) + " START =======");
			// each round add random number of cars to each lane
			if (i > 0) {
				laneWestNum = cars.get(0) + roadWest.getCarNum();
				laneEastNum = cars.get(1) + roadEast.getCarNum();
				laneNorthNum = cars.get(2) + roadNorth.getCarNum();
				laneSouthNum = cars.get(3) + roadSouth.getCarNum();
			}

			System.out.println("-------Cars waiting-------");
			System.out.println("West car Number : " + laneWestNum);
			System.out.println("East car Number : " + laneEastNum);
			System.out.println("North car Number : " + laneNorthNum);
			System.out.println("South car Number : " + laneSouthNum);
			System.out.println("--------------------------");

			cars.clear();
			cars.add(laneWestNum);
			cars.add(laneEastNum);
			cars.add(laneNorthNum);
			cars.add(laneSouthNum);

			roadWest.addCar(cars.get(0));
			roadEast.addCar(cars.get(1));
			roadNorth.addCar(cars.get(2));
			roadSouth.addCar(cars.get(3));

			final Queue<Direction> westLaneQueue = roadWest.getLaneQ();
			final Queue<Direction> eastLaneQueue = roadEast.getLaneQ();
			final Queue<Direction> northLaneQueue = roadNorth.getLaneQ();
			final Queue<Direction> southLaneQueue = roadSouth.getLaneQ();

			Color current_color_WE = lights.get(0).getColor();
			Color current_color_NS = lights.get(1).getColor();


			tc.decideLights(cars, lights, emergencySignal);

			Thread westEastDC_Thread = new Thread(new Runnable() {
				@Override
				public void run() {
					Queue<Queue<Direction>> tempQueue = westeastDC.controlDirection(new LinkedList<>(westLaneQueue), new LinkedList<>(eastLaneQueue), current_color_WE);
					Queue<Direction> newWestLaneQueue = tempQueue.poll();
					Queue<Direction> newEastLaneQueue = tempQueue.poll();

					List<Integer> decrease_east = westeastDC.decreaseCarNum(newWestLaneQueue, newEastLaneQueue, current_color_WE, cars.get(0), cars.get(1));
					cars.set(0, cars.get(0) - decrease_east.get(0));
					cars.set(1, cars.get(1) - decrease_east.get(1));

					// Updates the lane queue
					roadWest.setLaneQ(newWestLaneQueue);
					roadEast.setLaneQ(newEastLaneQueue);

					Color wanted_color_WE = lights.get(0).getColor();
					lights.get(0).changeLight(current_color_WE, wanted_color_WE);

					System.out.println("West move : " + decrease_east.get(0) + " cars");
					System.out.println("East move : " + decrease_east.get(1) + " cars");

				}
			});

			Thread northSouthDC_Thread = new Thread(new Runnable() {
				@Override
				public void run() {
					Queue<Queue<Direction>> tempQueue = northsouthDC.controlDirection(new LinkedList<>(southLaneQueue), new LinkedList<>(northLaneQueue), current_color_NS);
					Queue<Direction> newSouthLaneQueue = tempQueue.poll();
					Queue<Direction> newNorthLaneQueue = tempQueue.poll();

					List<Integer> decrease_south = northsouthDC.decreaseCarNum(newSouthLaneQueue, newNorthLaneQueue, current_color_NS, cars.get(3), cars.get(2));
					cars.set(2, cars.get(2) - decrease_south.get(1));
					cars.set(3, cars.get(3) - decrease_south.get(0));

					// Updates the lane queue
					roadNorth.setLaneQ(newNorthLaneQueue);
					roadSouth.setLaneQ(newSouthLaneQueue);

					Color wanted_color_NS = lights.get(1).getColor();
					lights.get(1).changeLight(current_color_NS, wanted_color_NS);

					System.out.println("North move : " + decrease_south.get(1) + " cars");
					System.out.println("South move : " + decrease_south.get(0) + " cars");
				}
			});

			// Multithreading for cars moving on each road
			Thread westRoadThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < cars.get(0); j++) {
						roadWest.moveCar();
					}
				}
			});

			Thread eastRoadThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < cars.get(1); j++) {
						roadEast.moveCar();
					}
				}
			});

			Thread northRoadThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < cars.get(2); j++) {
						roadNorth.moveCar();
					}
				}
			});

			Thread southRoadThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < cars.get(3); j++) {
						roadSouth.moveCar();
					}
				}
			});

			System.out.println("--------cars moved--------");
			westEastDC_Thread.start();
			northSouthDC_Thread.start();
			westRoadThread.start();
			eastRoadThread.start();
			northRoadThread.start();
			southRoadThread.start();

			try {
				westEastDC_Thread.join();
				northSouthDC_Thread.join();
				westRoadThread.join();
				eastRoadThread.join();
				northRoadThread.join();
				southRoadThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("---------------------------");

			System.out.println("West-East Lights Color: " + lights.get(0).getColor());
			System.out.println("North-South lights Color: " + lights.get(1).getColor());

			System.out.println("======= ROUND END =======");
			System.out.println();
		}
	}
}
