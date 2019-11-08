import java.util.ArrayList;

public class Plane {
	private String planeId;
	private int capacity;
	
	public Plane(String planeId, int capacity) {
		this.planeId = planeId;
		this.capacity = capacity;
	}

	public String getPlaneId() {
		return planeId;
	}

	public void setPlaneId(String planeId) {
		this.planeId = planeId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return this.planeId + " " + this.capacity + " persones";
	}

}
