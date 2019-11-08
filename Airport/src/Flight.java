import java.util.ArrayList;

public class Flight {
	private Plane plane;
	private String departureAirport;
	private String arrivalAirport;
	
	public Flight(Plane plane, String departureAirport, String arrivalAirport) {
		this.plane = plane;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	@Override
	public String toString() {
		return this.plane + " aeroport d'origen: " + this.departureAirport + " aeroport d'arribada: " + this.arrivalAirport;
	}

}
