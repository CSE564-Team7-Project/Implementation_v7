package traffic_management;

public class TrafficLight {
	private Color current_color;

	public TrafficLight() {
		current_color = Color.RED;
	}
	
	public void setColor(Color in) {
		current_color =  in;
	}

	public Color getColor() {
		return current_color;
	}


	// cases
	// red -> yellow -> green
	// green -> red

	public void changeLight(Color actual, Color wanted) {
		if (actual == wanted) {
			current_color = wanted;
		} else if (actual == Color.RED && wanted == Color.GREEN) {
			// red -> green
			current_color = wanted;
		} else if (actual == Color.GREEN && wanted == Color.RED) {
			// green -> yellow
			current_color = Color.YELLOW;
		} else if (actual == Color.YELLOW) {
			// yellow -> green
			current_color = Color.RED;
		}
	}

}