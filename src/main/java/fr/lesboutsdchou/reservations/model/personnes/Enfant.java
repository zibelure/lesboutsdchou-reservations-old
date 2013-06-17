package fr.lesboutsdchou.reservations.model.personnes;

public class Enfant extends Personne {

	@Override
	public String toString() {
		return "Enfant [getDateCreation()=" + getDateCreation()
				+ ", getAdresse()=" + getAdresse() + ", getId()=" + getId()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getDateNaissance()=" + getDateNaissance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
