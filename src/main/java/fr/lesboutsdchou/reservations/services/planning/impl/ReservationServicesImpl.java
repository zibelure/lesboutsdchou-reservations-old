package fr.lesboutsdchou.reservations.services.planning.impl;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.dao.planning.ReservationDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauReserve;
import fr.lesboutsdchou.reservations.services.planning.ReservationServices;

public class ReservationServicesImpl implements ReservationServices {
	
	ReservationDao reservationDao;	

	/*
	 * Constructeur
	 */
	public ReservationServicesImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.planning.ReservationServices#addReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void addReservation(CreneauReserve creneau) {
		reservationDao.addReservation(creneau);		
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.planning.ReservationServices#updateReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void updateReservation(CreneauReserve creneau) {
		reservationDao.updateReservation(creneau);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.planning.ReservationServices#deleteReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void deleteReservation(CreneauReserve creneau) {
		reservationDao.deleteReservation(creneau);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.planning.ReservationServices#findAllReservations()
	 */
	public List<CreneauReserve> findAllReservations() {
		// TODO Auto-generated method stub
		return reservationDao.findAllReservations();
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.planning.ReservationServices#findAllReservationsByDate(java.util.Date)
	 */
	public List<CreneauReserve> findAllReservationsByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.planning.ReservationServices#findAllReservationsByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<CreneauReserve> findAllReservationsByFamille(Famille famille) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.planning.ReservationServices#findReservationByEnfantAndByDate(fr.lesboutsdchou.reservations.model.personnes.Enfant, java.util.Date)
	 */
	public CreneauReserve findReservationByEnfantAndByDate(Enfant enfant, Date date) {
		return reservationDao.findReservationByEnfantAndByDate(enfant, date);
	}

}
