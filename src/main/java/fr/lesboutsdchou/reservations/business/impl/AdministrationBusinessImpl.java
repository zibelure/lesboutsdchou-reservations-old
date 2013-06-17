package fr.lesboutsdchou.reservations.business.impl;

import java.util.Iterator;
import java.util.List;

import fr.lesboutsdchou.reservations.business.AdministrationBusiness;
import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;
import fr.lesboutsdchou.reservations.services.personnes.AdresseServices;
import fr.lesboutsdchou.reservations.services.personnes.EnfantServices;
import fr.lesboutsdchou.reservations.services.personnes.FamilleServices;
import fr.lesboutsdchou.reservations.services.personnes.ParentServices;

public class AdministrationBusinessImpl implements AdministrationBusiness {
	
	AdresseServices adresseServices;
	EnfantServices enfantServices;
	FamilleServices familleServices;
	ParentServices parentServices;
	
	public AdministrationBusinessImpl(AdresseServices adresseServices,
									EnfantServices enfantServices,
									FamilleServices familleServices,
									ParentServices parentServices) {
		this.adresseServices = adresseServices;
		this.enfantServices = enfantServices;
		this.familleServices = familleServices;
		this.parentServices = parentServices;
	}


	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#ajouterFamille(java.lang.String)
	 */
	public void ajouterFamille(Famille famille) {
		if(famille != null) {
			//Adresse
			Adresse adresse = famille.getAdresse();
			if(adresse != null) {
				adresseServices.addAdresse(adresse);
			}
			//Enfants
			List<Enfant> enfants = famille.getEnfants();
			if(enfants != null) {
				for (Enfant enfant : enfants) {
					enfantServices.addEnfant(enfant);
				}
			}
			//Parents
			List<Parent> parents = famille.getParents();
			if(parents != null) {
				for (Parent parent : parents) {
					parentServices.addParent(parent);
				}
			}
			//Famille
			familleServices.addFamille(famille);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#ajouterAdresse(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void ajouterAdresse(Famille famille, Adresse adresse) {
		if(famille != null && adresse != null) {
			famille.setAdresse(adresse);
			adresseServices.addAdresse(adresse);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#ajouterEnfant(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void ajouterEnfant(Famille famille, Enfant enfant) {		
		//Enfants
		List<Enfant> enfants = chercherEnfants(famille);
		if(enfants != null) {
			enfants.add(enfant);
			famille.setEnfants(enfants);
			familleServices.updateFamille(famille);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#ajouterParent(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void ajouterParent(Famille famille, Parent parent) {
		//Parents
		List<Parent> parents = chercherParents(famille);
		if(parents != null) {
			parents.add(parent);
			famille.setParents(parents);
			familleServices.updateFamille(famille);
		}
	}

	
	
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#modifierFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void modifierFamille(Famille famille) {
		if(famille != null) {
			familleServices.updateFamille(famille);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#modifierAdresse(fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void modifierAdresse(Adresse adresse) {
		if(adresse != null) {
			adresseServices.updateAdresse(adresse);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#modifierEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void modifierEnfant(Enfant enfant) {
		if(enfant != null) {
			enfantServices.updateEnfant(enfant);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#modifierParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void modifierParent(Parent parent) {
		if(parent != null) {
			parentServices.updateParent(parent);
		}
	}

	
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#supprimerFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void supprimerFamille(Famille famille) {
		if(famille != null) {
			familleServices.deleteFamille(famille);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#supprimerAdresse(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void supprimerAdresse(Famille famille, Adresse adresse) {
		if(adresse != null && famille != null) {
			adresseServices.deleteAdresse(adresse);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#supprimerEnfant(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public void supprimerEnfant(Famille famille, Enfant enfant) {
		if(enfant != null && famille != null) {
			List<Enfant> enfants = chercherEnfants(famille);
			Iterator<Enfant> iterator = enfants.iterator();
			while ( iterator.hasNext() ) {
			    Enfant e = iterator.next();
			    if (e.getId()==enfant.getId()) {
			        // On supprime l'élément courant de la liste
			        iterator.remove();
			    }
			}
			famille.setEnfants(enfants);
			modifierFamille(famille);
			enfantServices.deleteEnfant(enfant);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#supprimerParent(fr.lesboutsdchou.reservations.model.personnes.Famille, fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void supprimerParent(Famille famille, Parent parent) {
		if(parent != null && famille != null) {
			List<Parent> parents = chercherParents(famille);
			Iterator<Parent> iterator = parents.iterator();
			while ( iterator.hasNext() ) {
			    Parent p = iterator.next();
			    if (p.getId()==parent.getId()) {
			        // On supprime l'élément courant de la liste
			        iterator.remove();
			    }
			}
			famille.setParents(parents);
			modifierFamille(famille);
			parentServices.deleteParent(parent);
		}
	}

	
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#chercherFamille(java.lang.String)
	 */
	public Famille chercherFamille(String numCaf) {
		return familleServices.findFamilleByNumcaf(numCaf);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#chercherAdresse(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public Adresse chercherAdresse(Famille famille) {
		return adresseServices.findAdressesByFamille(famille);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#chercherParents(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<Parent> chercherParents(Famille famille) {
		return parentServices.findAllParentsByFamille(famille);
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.AdministrationBusiness#chercherEnfants(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<Enfant> chercherEnfants(Famille famille) {
		return enfantServices.findAllEnfantsByFamille(famille);
	}

}
