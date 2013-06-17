/**
 * 
 */
package fr.lesboutsdchou.reservations.business.impl;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.business.ReservationBusiness;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauReserve;
import fr.lesboutsdchou.reservations.services.planning.ReservationServices;

/**
 * @author anadot
 *
 */
public class ReservationBusinessImpl implements ReservationBusiness {
	
	ReservationServices reservationServices;
	
	/*
	 * Constructeur
	 */
	public ReservationBusinessImpl(ReservationServices reservationServices) {
		this.reservationServices = reservationServices;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#reserver(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void reserver(CreneauReserve creneau) {
		reservationServices.addReservation(creneau);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#modifierReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void modifierReservation(CreneauReserve creneau) {
		reservationServices.updateReservation(creneau);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#supprimerReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void supprimerReservation(CreneauReserve creneau) {
		reservationServices.deleteReservation(creneau);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#rechercherReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public CreneauReserve rechercherReservation(CreneauReserve creneau) {
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#rechercherReservationsParEnfant(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public List<CreneauReserve> rechercherReservationsParEnfant(
			Famille famille, Enfant enfant) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#rechercherReservationsParEnfantParSemaine(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Enfant, java.util.Date)
	 */
	public List<CreneauReserve> rechercherReservationsParEnfantParSemaine(
			Famille famille, Enfant enfant, Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#rechercherReservationsParEnfantParJour(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Enfant, java.util.Date)
	 */
	public CreneauReserve rechercherReservationsParEnfantParJour(
			Famille famille, Enfant enfant, Date date) {
		// TODO Auto-generated method stub
		return reservationServices.findReservationByEnfantAndByDate(enfant, date);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#rechercherReservationsParSemaine(java.util.Date)
	 */
	public List<CreneauReserve> rechercherReservationsParSemaine(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.ReservationBusiness#rechercherReservationsParJour(java.util.Date)
	 */
	public List<CreneauReserve> rechercherReservationsParJour(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
