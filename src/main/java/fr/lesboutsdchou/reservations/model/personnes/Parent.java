package fr.lesboutsdchou.reservations.model.personnes;

public class Parent extends Personne {

	@Override
	public String toString() {
		return "Parent [getDateCreation()=" + getDateCreation()
				+ ", getAdresse()=" + getAdresse() + ", getId()=" + getId()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getDateNaissance()=" + getDateNaissance()
				+ ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}	
	
}
