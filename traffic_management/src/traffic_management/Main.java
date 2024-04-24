package traffic_management;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		//declare components
		TrafficController tc = new TrafficController(); //main trafficController
		DirectionControl westeastDC = new DirectionControl(); //directionControl for lane1&2
		DirectionControl northsouthDC = new DirectionControl(); //directionControl for lane3&4
		TrafficLight westeastLight = new TrafficLight(); //TrafficLight for lane1&2
		TrafficLight northsouthLight = new TrafficLight(); //TrafficLight for lane3&4

		Road roadWest = new Road();
		Road roadEast = new Road();
		Road roadNorth = new Road();
		Road roadSouth = new Road();

		//create list of each lane's car number: cars.get(0) = lane1, cars.get(1) = lane2....
		List<Integer> cars = new ArrayList<Integer>();
		//create list of two lights: lights.get(0) = lane1&2, lights.get(1) = lane3&4
		List<TrafficLight> lights = new ArrayList<TrafficLight>();
		lights.add(westeastLight); // initialize =  red
		lights.add(northsouthLight); // initialize =  red


		//initialize each lane's car number
		int laneWestNum = roadWest.getCarNum();
		int laneEastNum = roadEast.getCarNum();
		int laneNorthNum = roadNorth.getCarNum();
		int laneSouthNum = roadSouth.getCarNum();


		//100 rounds
		for(int i = 0; i < 50; i++) {
			System.out.println("======= ROUND " + (i+1)+ " START =======" );
			//each round add random number of cars to each lane
			if(i > 0) {
				laneWestNum = cars.get(0) + roadWest.getCarNum();
				laneEastNum = cars.get(1) + roadEast.getCarNum();
				laneNorthNum = cars.get(2) + roadNorth.getCarNum();
				laneSouthNum = cars.get(3) + roadSouth.getCarNum();

			}

			System.out.println("-------Cars waiting-------");
			System.out.println("West car Number : " +  laneWestNum);
			System.out.println("East car Number : " +  laneEastNum);
			System.out.println("North car Number : " +  laneNorthNum);
			System.out.println("South car Number : " +  laneSouthNum);
			System.out.println("--------------------------");

			cars.clear();
			cars.add(laneWestNum);
			cars.add(laneEastNum);
			cars.add(laneNorthNum);
			cars.add(laneSouthNum);


			roadWest.addCar(laneWestNum);
			roadEast.addCar(laneEastNum);
			roadNorth.addCar(laneNorthNum);
			roadSouth.addCar(laneSouthNum);

			Queue<Direction> westLaneQueue = roadWest.getLaneQ();
			Queue<Direction> eastLaneQueue = roadEast.getLaneQ();
			Queue<Direction> northLaneQueue = roadNorth.getLaneQ();
			Queue<Direction> southLaneQueue = roadSouth.getLaneQ();


			Color current_color_WE = lights.get(0).getColor();
			Color current_color_NS = lights.get(1).getColor();

			tc.decideLights(cars, lights);

			Queue<Queue<Direction>> tempQueue = westeastDC.controlDirection(westLaneQueue, eastLaneQueue, current_color_WE);

			//calculate how many cars move
			List<Integer> decrease_east = westeastDC.decreaseCarNum(westLaneQueue, eastLaneQueue, current_color_WE, cars.get(0), cars.get(1));
			cars.set(0, cars.get(0) - decrease_east.get(0));
			cars.set(1, cars.get(1) - decrease_east.get(1));

			westLaneQueue = tempQueue.peek();//directions of Lane_West
			tempQueue.poll();
			eastLaneQueue = tempQueue.peek();//directions of Lane_East

			tempQueue = northsouthDC.controlDirection(southLaneQueue, northLaneQueue, current_color_NS);

			//calculate how many cars move
			List<Integer> decrease_south = northsouthDC.decreaseCarNum(southLaneQueue, northLaneQueue, current_color_NS, cars.get(3), cars.get(2));
			cars.set(2, cars.get(2) - decrease_south.get(1));
			cars.set(3, cars.get(3) - decrease_south.get(0));

			southLaneQueue = tempQueue.peek();//directions of Lane_South
			tempQueue.poll();
			northLaneQueue = tempQueue.peek();//directions of Lane_North

			System.out.println("--------cars moved--------");
			System.out.println("West move : " +  decrease_east.get(0) + " cars");
			System.out.println("East move : " +  decrease_east.get(1) + " cars");
			System.out.println("North move : " +  decrease_south.get(1) + " cars");
			System.out.println("South move : " +  decrease_south.get(0) + " cars");
			System.out.println("---------------------------");


			Color wanted_color_WE = lights.get(0).getColor();
			Color wanted_color_NS = lights.get(1).getColor();

			lights.get(0).changeLight(current_color_WE, wanted_color_WE);
			lights.get(1).changeLight(current_color_NS, wanted_color_NS);

			System.out.println("eastbound Lights Color: " + lights.get(0).getColor());
			System.out.println("southbound lights Color: " + lights.get(1).getColor());

			System.out.println("======= ROUND END =======");
			System.out.println();

		}

	}

}