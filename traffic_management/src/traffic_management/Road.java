package traffic_management;

import java.util.Queue;

public class Road {

    TrafficLight light;
    CarCounter carCount;
    Lane lane;

    public Road() {
        light = new TrafficLight();
        carCount = new CarCounter();
        lane = new Lane();
    }

    // Get traffic light current color
    public Color getColor() {
        return light.getColor();
    }

    // Change traffic light color
    public void changeLight(Color in) {
        light.changeLight(light.getColor(), in);
    }

    // CarCounter current number of cars in lane
    public int getCarNum() {
        return carCount.getCount();
    }

    public void addCar(int i) {
        lane.add_car(i);
    }

    public Queue<Direction> getLaneQ() {
        return lane.getCarsWaiting();
    }

    public void dequeueLane() {
        lane.remove_car();
    }
    public void setLaneQ(Queue<Direction> queue) {
        lane.cars_waiting = queue;
    }



    public synchronized void moveCar() {
        lane.remove_car();
    }


}
