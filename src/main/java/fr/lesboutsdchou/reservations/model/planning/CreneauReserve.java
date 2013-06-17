package fr.lesboutsdchou.reservations.model.planning;

public class CreneauReserve extends Creneau {
	
	private boolean reservationValidee;

	public void setReservationValidee(boolean reservationValidee) {
		this.reservationValidee = reservationValidee;
	}
	public boolean isReservationValidee() {
		return reservationValidee;
	}
	@Override
	public String toString() {
		return "CreneauReserve [reservationValidee=" + reservationValidee
				+ ", getId()=" + getId() + ", getEnfant()=" + getEnfant()
				+ ", getFamille()=" + getFamille() + ", getDateHeureDebut()="
				+ getDateHeureDebut() + ", getDateHeureFin()="
				+ getDateHeureFin() + ", getDateReservation()="
				+ getDateReservation() + ", getSemaineReservation()="
				+ getSemaineReservation() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
}
