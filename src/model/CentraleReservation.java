package model;

public class CentraleReservation <F extends Formulaire, R extends EntiteReservable<F>>{
	private R[] entites;
	int nbEntites = 0;
	
	public CentraleReservation (R[] entites) {
		this.entites = entites;
	}
	
	public int ajouterEntite (R entite) {
		entites[nbEntites] = entite;
		nbEntites++;
		entites[nbEntites-1].setNumId(nbEntites);
		return nbEntites;
	}
	
	public int[] donnerPossibilites(F formulaire) {
		int[] possibilites = new int[nbEntites];

		for (int i=0; i<nbEntites; i++) {
			if(entites[i].compatible(formulaire)) {
				possibilites[i] = entites[i].getNumId();
			} else {
				possibilites[i] = 0;
			}
		}
		
		return possibilites;
	}
	
	public Reservation reserver(int numId, F formulaire) {
		R entite = null;
		for (int i=0; i<nbEntites; i++) {
			if (entites[i].getNumId() == numId) {
				entite = entites[i];
				break;
			}
		}
		
		if (entite == null)
			return null;
		
		formulaire.setIdentificationEntite(numId);
		return entite.reserver(formulaire);
	}
}
