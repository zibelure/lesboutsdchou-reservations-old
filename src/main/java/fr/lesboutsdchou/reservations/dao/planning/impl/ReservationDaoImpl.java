package fr.lesboutsdchou.reservations.dao.planning.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.lesboutsdchou.reservations.dao.planning.ReservationDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauReserve;

public class ReservationDaoImpl extends HibernateDaoSupport  implements ReservationDao {

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.planning.ReservationDao#addReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void addReservation(CreneauReserve creneau) {
		getHibernateTemplate().save(creneau);		
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.planning.ReservationDao#updateReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void updateReservation(CreneauReserve creneau) {
		getHibernateTemplate().update(creneau);		
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.planning.ReservationDao#deleteReservation(fr.lesboutsdchou.reservations.model.planning.CreneauReserve)
	 */
	public void deleteReservation(CreneauReserve creneau) {
		getHibernateTemplate().delete(creneau);		
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.planning.ReservationDao#findAllReservations()
	 */
	public List<CreneauReserve> findAllReservations() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from CreneauReserve");
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.planning.ReservationDao#findAllReservationsByDate(java.util.Date)
	 */
	public List<CreneauReserve> findAllReservationsByDate(Date date) {
		List<CreneauReserve> creneaux = null;
		if(date != null) {
			creneaux = getHibernateTemplate().find("from CreneauReserve as creneau where creneau.dateHeureDebut=?", date);
			//getSession().beginTransaction();
			//enfants =	getSession().createQuery("select enfant from " +
					//"Famille as famille left join famille.enfants enfant where famille.numCaf = :numcaf").setString("numcaf", famille.getNumCaf()).list();
		}
		return creneaux;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.planning.ReservationDao#findAllReservationsByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<CreneauReserve> findAllReservationsByFamille(Famille famille) {
		List<CreneauReserve> creneaux = null;
		if(famille != null) {
			creneaux = getHibernateTemplate().find("from CreneauReserve as creneau where creneau.famille=?", famille.getId());
			//getSession().beginTransaction();
			//enfants =	getSession().createQuery("select enfant from " +
					//"Famille as famille left join famille.enfants enfant where famille.numCaf = :numcaf").setString("numcaf", famille.getNumCaf()).list();
		}
		return creneaux;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.planning.ReservationDao#findReservationByEnfantAndByDate(fr.lesboutsdchou.reservations.model.personnes.Enfant, java.util.Date)
	 */
	public CreneauReserve findReservationByEnfantAndByDate(Enfant enfant, Date date) {
		CreneauReserve creneau = null;
		if(enfant != null && date != null) {
			//List<CreneauReserve> creneaux = getSession().createQuery("select creneau " +
				//	"from CreneauReserve as creneau left join creneau.enfant enfant " +
				//	"where enfant.nom=:nom and enfant.prenom=:prenom and creneau.dateHeureDebut>=:dateHeuredebut and creneau.dateHeureFin<:dateHeureFin").setString("nom", enfant.getNom()).setString("prenom", enfant.getPrenom()).setDate("dateHeuredebut",date).setDate("dateHeureFin",date).list();
			List<CreneauReserve> creneaux = getSession().createQuery("select creneau " +
					"from CreneauReserve as creneau left join creneau.enfant enfant " +
					"where enfant.nom=:nom and enfant.prenom=:prenom and creneau.dateHeureDebut>=:dateHeuredebut and creneau.dateHeureFin<:dateHeureFin").setString("nom", enfant.getNom()).setString("prenom", enfant.getPrenom()).setDate("dateHeuredebut",date).setDate("dateHeureFin",date).list();
			if(creneaux != null && creneaux.size()>=1) {
				creneau = creneaux.get(0);
			}
		}
		return creneau;
	}

}
