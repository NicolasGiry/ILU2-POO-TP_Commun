package model;

public abstract class Formulaire {
	protected int jour;
	protected int mois;
	protected int numEntiteReservee;
	
	public Formulaire (int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	public abstract int getJour();
	
	public abstract int getMois();
	
	public abstract int getIdentificationEntite();
	
	public abstract void setIdentificationEntite(int numEntiteReservee);
}
