package fr.lesboutsdchou.reservations.business;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauPlanifie;

public interface PlanificationBusiness {
	
	public void planifier(Famille famille, Enfant enfant, Date dateHeureDebut, Date dateHeureFin);
	
	public CreneauPlanifie rechercherPlanification(Famille famille, Enfant enfant, Date date);
	public List<CreneauPlanifie> rechercherPlanificationsParEnfant(Famille famille, Enfant enfant);

	public List<CreneauPlanifie> rechercherPlanificationsParSemaine(int semaine);
	public List<CreneauPlanifie> rechercherPlanificationsParJour(Date date);	

}