package fr.lesboutsdchou.reservations.dao.planning;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauPlanifie;

public interface PlanificationDao {
	
	void addPlanification(Enfant enfant, Date dateHeureDebut, Date dateHeureFin);
	
	List<CreneauPlanifie> findAllPlanifications();
	
	List<CreneauPlanifie> findAllPlanificationsByDate(Date date);
	
	List<CreneauPlanifie> findAllPlanificationsByFamille(Famille famille);
	
	CreneauPlanifie findPlanificationByEnfantAndByDate(Enfant enfant, Date date);
}
