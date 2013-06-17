package fr.lesboutsdchou.reservations.services.personnes;

import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;

public interface ParentServices {
		
	void addParent(Parent parent);
	
	void updateParent(Parent parent);
	
	void deleteParent(Parent parent);
	
	List<Parent> findAllParents();
	
	List<Parent> findAllParentsByEnfant(Enfant enfant);
	
	List<Parent> findAllParentsByFamille(Famille famille);
	
	List<Parent> findParentByNomPrenom(String nom, String prenom);

}
