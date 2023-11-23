package model;

public class ReservationRestaurant extends Reservation {
	private int numService;
	private int numTable;
	
	public ReservationRestaurant(int jour, int mois, int numTable, int numService) {
		super(jour, mois);
		this.numService = numService;
		this.numTable = numTable;
	}
	
	@Override
	public String toString() {
		String s = "Le " + jour + "/" + mois + "\nTable " + numTable + " pour le ";
		if (numService == 1) {
			s += "premier service.";
		} else if (numService == 2){
			s+= "deuxième service.";
		}
		return s;
	}
}
