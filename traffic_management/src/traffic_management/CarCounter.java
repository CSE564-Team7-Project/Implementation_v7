package traffic_management;
import java.util.Random;

public class CarCounter {
	//create random carNumber from 0-10
	Random random = new Random();
	private int carCount = 0;
	
	public void increment() { 
		carCount++;
	}

	public void increment(int i) {
		carCount += i;
	}
	
	public void decrement() {
		if (carCount > 0) {
			carCount--;
		} else {
			carCount = 0;
		}
	}

	public int getCount() {
		return carCount;
	}

	public void setCount(int count) {
		this.carCount = count;
	}

}