package fr.lesboutsdchou.reservations.model.planning;

import java.util.Date;
import java.util.GregorianCalendar;

import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;

public abstract class Creneau {
	
	private long id;
	private Enfant enfant;
	private Famille famille;
	private Date dateHeureDebut;
	private Date dateHeureFin;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Enfant getEnfant() {
		return enfant;
	}
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	public Date getDateHeureDebut() {
		return dateHeureDebut;
	}
	public void setDateHeureDebut(Date dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}
	public Date getDateHeureFin() {
		return dateHeureFin;
	}
	public void setDateHeureFin(Date dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}
	
	public Date getDateReservation() {
		return this.dateHeureDebut;
	}
	
	public int getSemaineReservation() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setGregorianChange(dateHeureDebut);
		return gc.getWeekYear();
	}
	
	@Override
	public String toString() {
		return "ReservationBusiness [id=" + id + ", enfant=" + enfant
				+ ", dateHeureDebut=" + dateHeureDebut + ", dateHeureFin="
				+ dateHeureFin + "]";
	}
	
}
