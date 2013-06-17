package fr.lesboutsdchou.reservations.business;

import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;

public interface AdministrationBusiness {
	
	public Famille chercherFamille(String numCaf);
	public Adresse chercherAdresse(Famille famille);
	public List<Parent> chercherParents(Famille famille);
	public List<Enfant> chercherEnfants(Famille famille);
	
	public void ajouterFamille(Famille famille);
	public void ajouterAdresse(Famille famille, Adresse adresse);
	public void ajouterParent(Famille famille, Parent parent);
	public void ajouterEnfant(Famille famille, Enfant enfant);
	
	public void modifierFamille(Famille famille);
	public void modifierAdresse(Adresse adresse);
	public void modifierParent(Parent parent);
	public void modifierEnfant(Enfant enfant);

	public void supprimerFamille(Famille famille);
	public void supprimerAdresse(Famille famille, Adresse adresse);
	public void supprimerParent(Famille famille, Parent parent);
	public void supprimerEnfant(Famille famille, Enfant enfant);
}
