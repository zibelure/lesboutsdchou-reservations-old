package fr.lesboutsdchou.reservations.dao.personnes;

import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;

public interface AdresseDao {
	
	void addAdresse(Adresse adresse);
	
	void updateAdresse(Adresse adresse);
	
	void deleteAdresse(Adresse adresse);
	
	Adresse findAdresseByFamille(Famille famille);
	
}
