import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	private HashMap<String,Plane> planes;
	private HashMap<String,Flight> flights;
	private Scanner reader;
	
	public UserInterface(Scanner reader) {
		this.planes = new HashMap<String, Plane>();
		this.flights = new HashMap<String, Flight>();
		this.reader = reader;
	}

	public HashMap<String, Plane> getPlanes() {
		return planes;
	}

	public void setPlanes(HashMap<String, Plane> planes) {
		this.planes = planes;
	}

	public HashMap<String, Flight> getFlights() {
		return flights;
	}

	public void setFlights(HashMap<String, Flight> flights) {
		this.flights = flights;
	}

	public Scanner getReader() {
		return reader;
	}

	public void setReader(Scanner reader) {
		this.reader = reader;
	}
	
	public void airportService() {
		System.out.println("Panell de l'aeroport");
		System.out.println("--------------------");
		System.out.println();
		
		while(true) {
			System.out.println("Seleccionar operació:");
			System.out.println("[1] Afegir un avió");
			System.out.println("[2] Afegir un vol");
			System.out.println("[X] Sortir");
			System.out.println(">");
			
			String option = reader.nextLine();
			
			if (option.equals("1")) {
				addPlane();
			} else if (option.equals("2")) {
				addFlight();
			} else if (option.equals("X")) {
				break;
			}
		}
	}
	
	public void addPlane() {
		System.out.println("Indicar un avió:");
		String planeId = reader.nextLine();
		System.out.println("Indicar la capacitat de passatge:");
		int capacity = Integer.parseInt(reader.nextLine());
		this.planes.put(planeId, new Plane(planeId, capacity));
	}
	
	public void addFlight() {
		System.out.println("Indicar un avió:");
		String planeId = reader.nextLine();
		Plane plane = planes.get(planeId);
		System.out.println("Indicar el codi de l'aeroport de sortida:");
		String departureAirport = reader.nextLine();
		System.out.println("Indicar el codi de l'aeroport d'arribada:");
		String arrivalAirport = reader.nextLine();
		this.flights.put(planeId, new Flight(plane, departureAirport, arrivalAirport));
	}
	
	public void flightService() {
		System.out.println("Servei de vol");
		System.out.println("-------------");
		System.out.println();
		
		while(true) {
			System.out.println("Seleccionar operació:");
			System.out.println("[1] Imprimir avions");
			System.out.println("[2] Imprimir vols");
			System.out.println("[3] Imprimir un avió");
			System.out.println("[X] Sortir");
			System.out.println(">");
			
			String option = reader.nextLine();
			
			if (option.equals("1")) {
				printPlanes();
			} else if (option.equals("2")) {
				printFlights();
			} else if (option.equals("3")) {
				printOnePlane();
			} else if (option.equals("X")) {
				break;
			}
		}
	}
	
	public void printFlights() {
		for (Flight flight : flights.values()) {
			System.out.println(flight);
		}
	}
	
	public void printPlanes() {
		for (Plane plane : planes.values()) {
			System.out.println(plane);
		}
	}
	
	public void printOnePlane() {
		System.out.println("Indicar un avió:");
		String planeId = reader.nextLine();
		Plane plane = planes.get(planeId);
		System.out.println(plane);
	}

}
