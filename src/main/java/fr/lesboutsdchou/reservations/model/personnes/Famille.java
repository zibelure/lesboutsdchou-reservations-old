package fr.lesboutsdchou.reservations.model.personnes;

import java.util.ArrayList;
import java.util.List;


public class Famille {

	private long id;
	private String numCaf;
	private Adresse adresse;
	private List<Parent> parents;
	private List<Enfant> enfants;
	
	public Famille() {
		if(parents == null) {
			parents = new ArrayList<Parent>();
		}
		if(enfants == null) {
			enfants = new ArrayList<Enfant>();
		}
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNumCaf() {
		return numCaf;
	}
	public void setNumCaf(String numCaf) {
		this.numCaf = numCaf;
	}
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Parent> getParents() {
		return parents;
	}
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	public List<Enfant> getEnfants() {
		return enfants;
	}
	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}
	
	public boolean isHabitantLiffre() {
		return true;
	}
	
	@Override
	public String toString() {
		return "Famille [id=" + id + ", numCaf=" + numCaf + ", adresse=" + adresse.toString()
		//		+ ", parents=" + parents.toString() + ", enfants=" + enfants.toString()
				+ "]";
	}
	
}
