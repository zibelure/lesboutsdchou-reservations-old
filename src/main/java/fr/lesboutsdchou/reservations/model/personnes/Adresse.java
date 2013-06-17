package fr.lesboutsdchou.reservations.model.personnes;

public class Adresse {

	private long id;
	private String voie;
	private String numVoie;
	private String codePostal;
	private String localite;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getNumVoie() {
		return numVoie;
	}
	public void setNumVoie(String numVoie) {
		this.numVoie = numVoie;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	@Override
	public String toString() {
		return "Adresse [voie=" + voie + ", numVoie=" + numVoie
				+ ", codePostal=" + codePostal + ", localite=" + localite + "]";
	}
	
	

}
