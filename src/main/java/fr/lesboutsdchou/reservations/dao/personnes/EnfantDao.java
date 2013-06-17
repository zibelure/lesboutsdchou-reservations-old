package fr.lesboutsdchou.reservations.dao.personnes;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;


public interface EnfantDao {
	
	void addEnfant(Enfant enfant);
	
	void updateEnfant(Enfant enfant);
	
	void deleteEnfant(Enfant enfant);
	
	List<Enfant> findAllEnfants();
	
	List<Enfant> findAllEnfantsByDate(Date date);
	
	List<Enfant> findAllEnfantsByFamille(Famille famille);
	
	List<Enfant> findEnfantByNomPrenom(String nom, String prenom);

}
