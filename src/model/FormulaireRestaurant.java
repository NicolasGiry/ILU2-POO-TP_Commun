package model;

public class FormulaireRestaurant extends Formulaire{
	private int nbPersonnes;
	private int numService;
	
	public FormulaireRestaurant(int jour, int mois, int nbPersonnes, int numService) {
		super(jour, mois);
		this.nbPersonnes = nbPersonnes;
		this.numService = numService;
	}

	public int getNombrePersonnes() {
		return nbPersonnes;
	}

	public int getNumService() {
		return numService;
	}
	
	public int getJour() {
		return jour;
	}
	
	public int getMois() {
		return mois;
	}
	
	public int getIdentificationEntite() {
		return numEntiteReservee;
	}
	
	public void setIdentificationEntite(int numEntiteReservee) {
		this.numEntiteReservee = numEntiteReservee;
	}
}
