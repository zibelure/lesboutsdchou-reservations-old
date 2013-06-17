package fr.lesboutsdchou.reservations.services.personnes.impl;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.dao.personnes.EnfantDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.services.personnes.EnfantServices;

public class EnfantServicesImpl implements EnfantServices {
	
	EnfantDao enfantDao;

	/*
	 * 
	 */
	public EnfantServicesImpl(EnfantDao enfantDao) {
		this.enfantDao = enfantDao;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.EnfantServices#addEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant, fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void addEnfant(Enfant enfant) {
		enfantDao.addEnfant(enfant);
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.EnfantServices#updateEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void updateEnfant(Enfant enfant) {
		enfantDao.updateEnfant(enfant);
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.EnfantServices#deleteEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void deleteEnfant(Enfant enfant) {
		enfantDao.deleteEnfant(enfant);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.EnfantServices#findAllEnfants()
	 */
	public List<Enfant> findAllEnfants() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.EnfantServices#findAllEnfantsByDate(java.util.Date)
	 */
	public List<Enfant> findAllEnfantsByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.EnfantServices#findAllEnfantsByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<Enfant> findAllEnfantsByFamille(Famille famille) {
		return enfantDao.findAllEnfantsByFamille(famille);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.EnfantServices#findEnfantByNomPrenom(java.lang.String, java.lang.String)
	 */
	public List<Enfant> findEnfantByNomPrenom(String nom, String prenom) {
		return enfantDao.findEnfantByNomPrenom(nom, prenom);
	}

}
