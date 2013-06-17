package fr.lesboutsdchou.reservations.services.personnes.impl;

import java.util.List;

import fr.lesboutsdchou.reservations.dao.personnes.ParentDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;
import fr.lesboutsdchou.reservations.services.personnes.ParentServices;

public class ParentServicesImpl implements ParentServices {
	
	ParentDao parentDao;

	/*
	 * 
	 */
	public ParentServicesImpl(ParentDao parentDao) {
		this.parentDao = parentDao;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.ParentServices#addParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void addParent(Parent parent) {
		parentDao.addParent(parent);
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.ParentServices#updateParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void updateParent(Parent parent) {
		parentDao.updateParent(parent);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.ParentServices#deleteParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void deleteParent(Parent parent) {
		parentDao.deleteParent(parent);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.ParentServices#findAllParents()
	 */
	public List<Parent> findAllParents() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.ParentServices#findAllParentsByEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public List<Parent> findAllParentsByEnfant(Enfant enfant) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.ParentServices#findAllParentsByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<Parent> findAllParentsByFamille(Famille famille) {
		return parentDao.findAllParentsByFamille(famille);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.services.personnes.ParentServices#findParentByNomPrenom(java.lang.String, java.lang.String)
	 */
	public List<Parent> findParentByNomPrenom(String nom, String prenom) {
		return parentDao.findParentByNomPrenom(nom, prenom);
	}

}
