package model;

public class Restaurant {
	CentraleReservation<FormulaireRestaurant, Table> centrale;
	
	public Restaurant() {
		centrale = new CentraleReservation<>(new Table[100]);
	}
	
	public class Table extends EntiteReservable <FormulaireRestaurant> {
		private int nbChaises;
		private CalendrierAnnuel calendrierDeuxiemeService;

		public Table(int nbChaises) {
			super(new CalendrierAnnuel());
			this.nbChaises = nbChaises;
			this.calendrierDeuxiemeService = new CalendrierAnnuel();
		}

		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			if (formulaire.getNombrePersonnes() == nbChaises || formulaire.getNombrePersonnes()+1 == nbChaises) {
				if (formulaire.getNumService() == 1) {
					return super.calendrierPersonnel.estLibre(formulaire.getJour(), formulaire.getMois());
				} else if (formulaire.getNumService() == 2) {
					return calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois());
				}
			}
			return false;
		}

		@Override
		public Reservation reserver(FormulaireRestaurant formulaire) {
			if (compatible(formulaire)) {
				ReservationRestaurant reservation = new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(),super.numId, formulaire.getNumService());	
				return reservation;
			} else {
				return null;
			}
		}

	}
	
	public void ajouterTable(int nbChaises) {
		Table table = new Table(nbChaises);
		centrale.ajouterEntite(table);
	}
	
	public int[] donnerPossibilites (FormulaireRestaurant formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}
	
	public Reservation reserver(int numId, FormulaireRestaurant formulaire) {
		return centrale.reserver(numId, formulaire);
	}
}
