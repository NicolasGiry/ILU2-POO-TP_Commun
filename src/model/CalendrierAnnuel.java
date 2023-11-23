package model;

public class CalendrierAnnuel {
	
	private Mois calendrier[];
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		calendrier[0] = new Mois("Janvier", 31);
		calendrier[1] = new Mois("Fevrier", 28);
		calendrier[2] = new Mois("Mars", 31);
		calendrier[3] = new Mois("Avril", 30);
		calendrier[4] = new Mois("Mai", 31);
		calendrier[5] = new Mois("Juin", 30);
		calendrier[6] = new Mois("Juillet", 31);
		calendrier[7] = new Mois("Aout", 31);
		calendrier[8] = new Mois("Septembre", 30);
		calendrier[9] = new Mois("Octobre", 31);
		calendrier[10] = new Mois("Novembre", 30);
		calendrier[11] = new Mois("Decembre", 31);
	}
	
	private class Mois {
		private String nom;
		private boolean jour[];
		
		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jour = new boolean[nbJours];
		}
		
		private boolean estLibre(int numeroJour) {
			return !jour[numeroJour-1];
		}
		
		private void reserver(int numeroJour) throws IllegalStateException {
			if (!estLibre(numeroJour))
				throw new IllegalStateException("Le jour doit etre libre.");
			else
				jour[numeroJour-1] = true;
		}
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		try {
			calendrier[mois-1].reserver(jour);
		}
		catch (IllegalStateException e) {
			return false;
		}
		return true;
	}
}
