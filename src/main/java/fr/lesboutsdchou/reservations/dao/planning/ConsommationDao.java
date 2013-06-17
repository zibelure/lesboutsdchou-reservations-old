package fr.lesboutsdchou.reservations.dao.planning;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauConsomme;

public interface ConsommationDao {
void addPlanification(Enfant enfant, Date dateHeureDebut, Date dateHeureFin);
	
	List<CreneauConsomme> findAllConsommations();
	
	List<CreneauConsomme> findAllConsommationsByDate(Date date);
	
	List<CreneauConsomme> findAllConsommationsByFamille(Famille famille);
	
	CreneauConsomme findConsommationByEnfantAndByDate(Enfant enfant, Date date);
}
