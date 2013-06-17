package fr.lesboutsdchou.reservations.services.personnes;

import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;

public interface AdresseServices {
	
	void addAdresse(Adresse adresse);
	
	void updateAdresse(Adresse adresse);
	
	void deleteAdresse(Adresse adresse);
	
	List<Famille> findAllFamilles();
	
	Adresse findAdressesByFamille(Famille famille);
	
}
