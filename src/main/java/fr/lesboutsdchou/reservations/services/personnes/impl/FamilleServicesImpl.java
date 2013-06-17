package fr.lesboutsdchou.reservations.services.personnes.impl;

import java.util.List;

import fr.lesboutsdchou.reservations.dao.personnes.FamilleDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;
import fr.lesboutsdchou.reservations.services.personnes.FamilleServices;

public class FamilleServicesImpl implements FamilleServices {
	
	FamilleDao familleDao;	

	public FamilleServicesImpl(FamilleDao familleDao) {
		this.familleDao = familleDao;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.FamilleServices#addFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void addFamille(Famille famille) {
		familleDao.addFamille(famille);
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.FamilleServices#updateFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void updateFamille(Famille famille) {
		familleDao.updateFamille(famille);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.FamilleServices#deleteFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void deleteFamille(Famille famille) {
		familleDao.deleteFamille(famille);
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.FamilleServices#findFamilleByNumcaf(java.lang.String)
	 */
	public Famille findFamilleByNumcaf(String numCaf) {
		return familleDao.findFamilleByNumcaf(numCaf);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.FamilleServices#findAllFamilles()
	 */
	public List<Famille> findAllFamilles() {
		return familleDao.findAllFamilles();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.FamilleServices#findFamilleByEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public Famille findFamilleByEnfant(Enfant enfant) {
		return familleDao.findFamilleByEnfant(enfant);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.FamilleServices#findFamilleByParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public Famille findFamilleByParent(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
