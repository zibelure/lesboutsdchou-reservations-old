package fr.lesboutsdchou.reservations.services.personnes.impl;

import java.util.List;

import fr.lesboutsdchou.reservations.dao.personnes.AdresseDao;
import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.services.personnes.AdresseServices;

public class AdresseServicesImpl implements AdresseServices {
	
	AdresseDao adresseDao;

	/*
	 * 
	 */
	public AdresseServicesImpl(AdresseDao adresseDao) {
		this.adresseDao = adresseDao;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.AdresseServices#addAdresse(fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void addAdresse(Adresse adresse) {
		adresseDao.addAdresse(adresse);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.AdresseServices#updateAdresse(fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void updateAdresse(Adresse adresse) {
		adresseDao.updateAdresse(adresse);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.AdresseServices#deleteAdresse(fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void deleteAdresse(Adresse adresse) {
		adresseDao.deleteAdresse(adresse);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.AdresseServices#findAllFamilles()
	 */
	public List<Famille> findAllFamilles() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.AdresseServices#findAdressesByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public Adresse findAdressesByFamille(Famille famille) {
		// TODO Auto-generated method stub
		return null;
	}

}
