package traffic_management;

import java.util.LinkedList;
import java.util.Queue;

public class Lane {
	Queue<Direction> cars_waiting = new LinkedList<>();
	Car Car = new Car();

	public void add_car(int i) {
		for(int j = 0; j < i; j++) {
			cars_waiting.offer(Car.getCarDirect());
		}
	}

	public void remove_car() {
		if (!cars_waiting.isEmpty()) {
			cars_waiting.poll();
		}
	}

	public Queue<Direction> getCarsWaiting() {
		return cars_waiting;
	}
}