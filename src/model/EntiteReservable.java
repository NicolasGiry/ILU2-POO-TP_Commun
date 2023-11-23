package model;

public abstract class EntiteReservable <F extends Formulaire> {
	protected CalendrierAnnuel calendrierPersonnel;
	protected int numId;
	
	public EntiteReservable(CalendrierAnnuel calendrierPersonnel) {
		this.calendrierPersonnel = calendrierPersonnel;
	}

	public int getNumId() {
		return numId;
	}
	
	public void setNumId(int numId) {
		this.numId = numId;
	}
	
	public boolean estLibre(F formulaire) {
		return calendrierPersonnel.estLibre(formulaire.getJour(), formulaire.getMois());
	}
	
	public abstract boolean compatible(F formulaire);
	
	public abstract Reservation reserver(F formulaire);
}
