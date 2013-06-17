package fr.lesboutsdchou.reservations.services.planning;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauReserve;


public interface ReservationServices {
	
	void addReservation(CreneauReserve creneau);
	
	void updateReservation(CreneauReserve creneau);
	
	void deleteReservation(CreneauReserve creneau);
	
	List<CreneauReserve> findAllReservations();
	
	List<CreneauReserve> findAllReservationsByDate(Date date);
	
	List<CreneauReserve> findAllReservationsByFamille(Famille famille);
	
	CreneauReserve findReservationByEnfantAndByDate(Enfant enfant, Date date);

}
