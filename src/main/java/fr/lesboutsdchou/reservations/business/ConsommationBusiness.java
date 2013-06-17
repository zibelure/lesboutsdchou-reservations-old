package fr.lesboutsdchou.reservations.business;

import java.util.Date;
import java.util.List;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.planning.CreneauConsomme;

public interface ConsommationBusiness {
	
	public void consommer(Famille famille, Enfant enfant, Date dateHeureDebut, Date dateHeureFin);
	
	public CreneauConsomme rechercherConsommation(Famille famille, Enfant enfant, Date date);
	public List<CreneauConsomme> rechercherConsommationsParEnfant(Famille famille, Enfant enfant);
	
	public List<CreneauConsomme> rechercherConsommationsParSemaine(int semaine);
	public List<CreneauConsomme> rechercherConsommationsParJour(Date date);

}
