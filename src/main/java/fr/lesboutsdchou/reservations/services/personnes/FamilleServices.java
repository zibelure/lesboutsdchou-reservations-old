package fr.lesboutsdchou.reservations.services.personnes;

import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;

public interface FamilleServices {
	
	void addFamille(Famille famille);
	
	void updateFamille(Famille famille);
	
	void deleteFamille(Famille famille);

	Famille findFamilleByNumcaf(String numCaf);
	
	List<Famille> findAllFamilles();
	
	Famille findFamilleByEnfant(Enfant enfant);
	
	Famille findFamilleByParent(Parent parent);
	
}
