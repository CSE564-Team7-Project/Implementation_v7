package traffic_management;

public class TrafficLight {
	private Color myColor;

	public TrafficLight() {
		myColor = Color.RED;
	}
	
	public void setColor(Color in) {
		myColor =  in;
	}

	public Color getColor() {
		return myColor;
	}

	public void changeLight(Color current, Color wanted) {
		if (current == wanted) {
			myColor = wanted;
		} else if (current == Color.RED && wanted == Color.GREEN) {
			// red -> yellow
			myColor = Color.YELLOW;
		} else if (current == Color.YELLOW) {
			// yellow -> green
			myColor = Color.GREEN;
		} else if (current == Color.GREEN && wanted == Color.RED) {
			// green -> red
			myColor = wanted;
		}
	}

}