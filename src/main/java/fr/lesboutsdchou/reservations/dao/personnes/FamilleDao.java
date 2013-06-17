package fr.lesboutsdchou.reservations.dao.personnes;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;

public interface FamilleDao {
	
	void addFamille(Famille famille);
	
	void updateFamille(Famille famille);
	
	void deleteFamille(Famille famille);
	
	List<Famille> findAllFamilles();
	
	Famille findFamilleByNumcaf(String numCaf);
	
	Famille findFamilleByEnfant(Enfant enfant);
	
	Famille findFamilleByParent(Parent parent);
	
}
