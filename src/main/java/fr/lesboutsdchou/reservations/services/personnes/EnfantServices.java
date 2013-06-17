package fr.lesboutsdchou.reservations.services.personnes;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;


public interface EnfantServices {
	
	void addEnfant(Enfant enfant);
	
	void updateEnfant(Enfant enfant);
	
	void deleteEnfant(Enfant enfant);
	
	List<Enfant> findAllEnfants();
	
	List<Enfant> findAllEnfantsByDate(Date date);
	
	List<Enfant> findAllEnfantsByFamille(Famille famille);
	
	List<Enfant> findEnfantByNomPrenom(String nom, String prenom);

}
