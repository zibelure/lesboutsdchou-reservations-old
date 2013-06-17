package fr.lesboutsdchou.reservations.dao.personnes.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.lesboutsdchou.reservations.dao.personnes.EnfantDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;

public class EnfantDaoImpl extends HibernateDaoSupport implements EnfantDao {
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.EnfantDao#addEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void addEnfant(Enfant enfant) {
		getHibernateTemplate().save(enfant);
		//getSession().beginTransaction();
		//getSession().save(enfant);
		//getSession().getTransaction().commit();
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.EnfantDao#updateEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void updateEnfant(Enfant enfant) {
		getHibernateTemplate().update(enfant);
		//getSession().beginTransaction();
		//getSession().update(enfant);
		//getSession().getTransaction().commit();
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.EnfantDao#deleteEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void deleteEnfant(Enfant enfant) {
		getHibernateTemplate().delete(enfant);
		//getSession().beginTransaction();
		//getSession().delete(enfant);
		//getSession().getTransaction().commit();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.EnfantDao#findAllEnfants()
	 */
	public List<Enfant> findAllEnfants() {
		List<Enfant> enfants = getHibernateTemplate().find("from Enfant");
		//getSession().beginTransaction();
		//List<Enfant> enfants = getSession().createQuery("from Enfant").list();
		return enfants;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.EnfantDao#findAllEnfantsByDate(java.util.Date)
	 */
	public List<Enfant> findAllEnfantsByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.EnfantDao#findAllEnfantsByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<Enfant> findAllEnfantsByFamille(Famille famille) {
		List<Enfant> enfants = null;
		if(famille != null) {
			enfants = getHibernateTemplate().find("select enfant from Famille as famille left join famille.enfants enfant where famille.numCaf=?", famille.getNumCaf());
			//getSession().beginTransaction();
			//enfants =	getSession().createQuery("select enfant from " +
					//"Famille as famille left join famille.enfants enfant where famille.numCaf = :numcaf").setString("numcaf", famille.getNumCaf()).list();
		}
		return enfants;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.EnfantDao#findEnfantByNomPrenom(java.lang.String, java.lang.String)
	 */
	public List<Enfant> findEnfantByNomPrenom(String nom, String prenom) {
		List<Enfant> enfants = getHibernateTemplate().find("from Enfant as enfant where enfant.nom=? and enfant.prenom=?",  new String [] {nom, prenom});
		//getSession().beginTransaction();
		//List<Enfant> enfants = getSession().createQuery("from enfant where enfant.nom=:nom and enfant.prenom=:prenom").setString("nom", nom).setString("prenom", prenom).list(); //, new String [] {nom, prenom});
		return enfants;
	}

}
