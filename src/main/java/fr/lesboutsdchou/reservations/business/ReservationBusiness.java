package fr.lesboutsdchou.reservations.business;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauReserve;

public interface ReservationBusiness {
	
	public void reserver(CreneauReserve creneau);
	public void modifierReservation(CreneauReserve creneau);
	public void supprimerReservation(CreneauReserve creneau);
	
	public CreneauReserve rechercherReservation(CreneauReserve creneau);
	public List<CreneauReserve> rechercherReservationsParEnfant(Famille famille, Enfant enfant);
	public List<CreneauReserve> rechercherReservationsParEnfantParSemaine(Famille famille, Enfant enfant, Date date);
	public CreneauReserve rechercherReservationsParEnfantParJour(Famille famille, Enfant enfant, Date date);
	
	public List<CreneauReserve> rechercherReservationsParSemaine(Date date);
	public List<CreneauReserve> rechercherReservationsParJour(Date date);

}
