import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;

import fr.lesboutsdchou.reservations.business.AdministrationBusiness;
import fr.lesboutsdchou.reservations.business.BusinessFactory;
import fr.lesboutsdchou.reservations.business.impl.BusinessFactoryImpl;
import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;
import fr.lesboutsdchou.reservations.services.BeanFactory;
import fr.lesboutsdchou.reservations.services.personnes.FamilleServices;

public class Test2 {

	ApplicationContext context = BeanFactory.getInstance().getContext();
	BusinessFactory businessFactory = (BusinessFactoryImpl) context.getBean("businessFactory");
	AdministrationBusiness administrationBusiness = businessFactory.getAdministrationBusiness();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//
		Test2 test = new Test2();
		
		//Ajouter une famille
		test.ajouterNouvelleFamille();
		
		//Afficher la famille
//		test.afficherFamille();
		
		//Modifier famille
//		test.modifierFamille();
		
		//Ajouter enfant
//		test.ajouterEnfant();

		//Ajouter parents
//		test.ajouterParent();

		//Afficher la famille
//		test.afficherFamille();
		
		//
//		test.superTest();

	}
	
	
	

	/*
	 * afficherFamille
	 */
	public void afficherFamille() {
		Famille famille = administrationBusiness.chercherFamille("00002");
		if (famille != null) {
			System.out.println(famille.toString());
		}
		List<Enfant> enfants = administrationBusiness.chercherEnfants(famille);	
		if (enfants != null) {
			int i = 0;
			for (Enfant enfant : enfants) {
				i++;
				if (enfant != null) {
					System.out.println(i + " : " + enfant.toString());
				}
			}
		}
		List<Parent> parents = administrationBusiness.chercherParents(famille);
		if (parents != null) {
			int i = 0;
			for (Parent parent : parents) {
				i++;
				if (parent != null) {
					System.out.println(i + " : " + parent.toString());
				}
			}
		}
	}
	
	/*
	 * modifierFamille
	 */
	public void modifierFamille() {
		Famille famille = administrationBusiness.chercherFamille("00002");
		List<Enfant> enfants = administrationBusiness.chercherEnfants(famille);	
		int i = 0;
		if (enfants != null) {
			for (Enfant enfant : enfants) {
				i++;
				if (enfant != null) {
					enfant.setNom("McCartney");
					enfant.setPrenom("Paul");
					administrationBusiness.modifierEnfant(enfant);
				}
			}
		}
		
		List<Parent> parents = administrationBusiness.chercherParents(famille);	
		i = 0;
		if (parents != null) {
			for (Parent parent : parents) {
				i++;
				if (parent != null) {
					parent.setNom("McCartney");
					parent.setPrenom("Mary");
					administrationBusiness.modifierParent(parent);
				}
			}
		}
		
	}
	
	
	
	//
	public void ajouterEnfant() {
		
		Famille famille = administrationBusiness.chercherFamille("00002");

		List<Enfant> enfants = administrationBusiness.chercherEnfants(famille);
		
		//Ajout enfants
		Enfant enfant = new Enfant();
		enfant.setNom("Harrisson");
		enfant.setPrenom("George");
		//Gestion des dates
		Date dateNaissanceEnfant = null;
		try {
			dateNaissanceEnfant = simpleDateFormat.parse("17/06/2010 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		enfant.setDateNaissance(dateNaissanceEnfant);
		enfant.setDateCreation(new Date());
		enfants.add(enfant);
		administrationBusiness.ajouterEnfant(famille, enfant);
		
	}
	
	
	//
	public void ajouterParent() {
		
		Famille famille = administrationBusiness.chercherFamille("00002");

		List<Parent> parents = administrationBusiness.chercherParents(famille);
		
		//Ajout parents
		Parent parent = new Parent();
		parent.setNom("Mc Cartney");
		parent.setPrenom("Jim");
		//Gestion des dates
		Date dateNaissanceParent = null;
		try {
			dateNaissanceParent = simpleDateFormat.parse("07/07/1902 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		parent.setDateNaissance(dateNaissanceParent);
		parent.setDateCreation(new Date());
		parents.add(parent);
		administrationBusiness.ajouterParent(famille, parent);		
	}
	
	
	
	/*
	 * ajouterNouvelleFamille
	 */
	public void ajouterNouvelleFamille() {
		Famille famille = new Famille();
		famille.setNumCaf("00002");
		
		//Ajout adresse
		Adresse adresse = new Adresse();
		adresse.setVoie("Dakota Building");
		adresse.setNumVoie("1");
		adresse.setCodePostal("91000");
		adresse.setLocalite("New York");

		//Ajout enfants
		Enfant enfant = new Enfant();
		enfant.setNom("Lennon");
		enfant.setPrenom("John");
		enfant.setAdresse(adresse);
		famille.setAdresse(adresse);
		List<Enfant> enfants = new ArrayList<Enfant>();
		enfants.add(enfant);
		famille.setEnfants(enfants);
		
		
		//Ajout parents
		Parent parent = new Parent();
		parent.setNom("Mimi");
		parent.setPrenom("Aunt");
		parent.setAdresse(adresse);
		List<Parent> parents = new ArrayList<Parent>();
		parents.add(parent);
		famille.setParents(parents);


		//Gestion des dates
		Date dateNaissanceEnfant = null;
		Date dateNaissanceParent = null;
		try {
			dateNaissanceEnfant = simpleDateFormat.parse("17/06/2010 00:00:00");
			dateNaissanceParent = simpleDateFormat.parse("17/06/1972 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		enfant.setDateNaissance(dateNaissanceEnfant);
		parent.setDateNaissance(dateNaissanceParent);
		enfant.setDateCreation(new Date());
		parent.setDateCreation(new Date());
		
		//
		administrationBusiness.ajouterFamille(famille);
	}
	
	public void supprimerEnfant() {
		Famille famille = administrationBusiness.chercherFamille("00001");
		List<Enfant> enfants = administrationBusiness.chercherEnfants(famille);
		
	}
	

	public void supprimerFamille() {
		Famille famille = administrationBusiness.chercherFamille("00001");
		administrationBusiness.supprimerFamille(famille);
	}
}
