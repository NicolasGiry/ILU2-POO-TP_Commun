package model;

public class Table extends EntiteReservable <FormulaireRestaurant> {
	private int nbChaises;
	private CalendrierAnnuel calendrierDeuxiemeService;

	public Table(CalendrierAnnuel calendrierPersonnel, CalendrierAnnuel calendrierDeuxiemeService, int numId, int nbChaises) {
		super(calendrierPersonnel, numId);
		this.nbChaises = nbChaises;
		this.calendrierDeuxiemeService = calendrierDeuxiemeService;
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
			ReservationRestaurant reservation = new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), formulaire.getNombrePersonnes(), super.numId);	
			return reservation;
		} else {
			return null;
		}
	}

}
