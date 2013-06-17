/**
 * 
 */
package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;

import fr.lesboutsdchou.reservations.business.AdministrationBusiness;
import fr.lesboutsdchou.reservations.business.BusinessFactory;
import fr.lesboutsdchou.reservations.business.impl.BusinessFactoryImpl;
import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;
import fr.lesboutsdchou.reservations.services.BeanFactory;

/**
 * @author anadot
 *
 */
public class AdministrationBusinessTest extends TestCase {
	
	ApplicationContext context;
	BusinessFactory businessFactory;
	AdministrationBusiness administrationBusiness;
	SimpleDateFormat simpleDateFormat;
	
	public AdministrationBusinessTest(String administrationBusiness) {
		super(administrationBusiness);
	}
	
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
	    super.setUp();
	    context = BeanFactory.getInstance().getContext();
		businessFactory = (BusinessFactoryImpl) context.getBean("businessFactory");
		administrationBusiness = businessFactory.getAdministrationBusiness();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	}
	
	/*
	 * testAjouterNouvelleFamille
	 */
	public void testAjouterNouvelleFamille() {
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
		
		//Ajout de la nouvelle famille
		administrationBusiness.ajouterFamille(famille);
		
		//Vérification de l'ajout
		famille = administrationBusiness.chercherFamille("00002");
		adresse = administrationBusiness.chercherAdresse(famille);
		if (famille != null) {
			assertEquals("numCaf correct", "00002", famille.getNumCaf());
			if (adresse != null) {
				assertEquals("localite correct", "New York", adresse.getLocalite());
			}
		} else {
			
		}
		enfants = administrationBusiness.chercherEnfants(famille);	
		assertEquals("nom enfant correct", "Lennon", enfants.get(0).getNom());
		assertEquals("prenom enfant correct", "John", enfants.get(0).getPrenom());
		assertEquals("dateNaissance enfant correct", dateNaissanceEnfant, enfants.get(0).getDateNaissance());

		parents = administrationBusiness.chercherParents(famille);
		assertEquals("nom parent correct", "Mimi", parents.get(0).getNom());
		assertEquals("prenom parent correct", "Aunt", parents.get(0).getPrenom());
		assertEquals("dateNaissance parent correct", dateNaissanceParent, parents.get(0).getDateNaissance());
		
	}
	
	
	/*
	 * testModifierFamille
	 */
	public void testModifierFamille() {
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
		

		//Vérification de la modification
		enfants = administrationBusiness.chercherEnfants(famille);
		assertEquals("nom enfant " + i + " correct", "McCartney", enfants.get(0).getNom());
		assertEquals("prenom enfant " + i + " correct", "Paul", enfants.get(0).getPrenom());
		
		parents = administrationBusiness.chercherParents(famille);
		assertEquals("nom parent " + i + " correct", "McCartney", parents.get(0).getNom());
		assertEquals("prenom parent " + i + " correct", "Mary", parents.get(0).getPrenom());
		
	}
	
	/*
	 * testAjouterEnfant
	 */
	public void testAjouterEnfant() {
		
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
		
		
		//Vérification de l'ajout d'un enfant
		enfants = administrationBusiness.chercherEnfants(famille);
		assertEquals("nom enfant 1 correct", "McCartney", enfants.get(0).getNom());
		assertEquals("prenom enfant 1 correct", "Paul", enfants.get(0).getPrenom());
		assertEquals("nom enfant 2 correct", "Harrisson", enfants.get(1).getNom());
		assertEquals("prenom enfant 2 correct", "George", enfants.get(1).getPrenom());
		
	}
	
	/*
	 * testAjouterParent
	 */
	public void testAjouterParent() {
		
		Famille famille = administrationBusiness.chercherFamille("00002");

		List<Parent> parents = administrationBusiness.chercherParents(famille);
		
		//Ajout parents
		Parent parent = new Parent();
		parent.setNom("McCartney");
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

		//Vérification de l'ajout d'un parent
		parents = administrationBusiness.chercherParents(famille);
		assertEquals("nom parent 1 correct", "McCartney", parents.get(0).getNom());
		assertEquals("prenom parent 1 correct", "Mary", parents.get(0).getPrenom());
		assertEquals("nom parent 2 correct", "McCartney", parents.get(1).getNom());
		assertEquals("prenom parent 2 correct", "Jim", parents.get(1).getPrenom());
	}
	
	/*
	 * testSupprimerEnfant
	 */
	public void testSupprimerEnfant() {
		Famille famille = administrationBusiness.chercherFamille("00002");
		List<Enfant> enfants = administrationBusiness.chercherEnfants(famille);
		assertEquals("nombre d'enfants correct", 2, enfants.size());
		
		Enfant enfant = enfants.get(0);
		administrationBusiness.supprimerEnfant(famille, enfant);
		
		//Vérification de la suppression
		famille = null;
		famille = administrationBusiness.chercherFamille("00002");
		enfants = administrationBusiness.chercherEnfants(famille);
		assertEquals("nombre d'enfants correct", 1, enfants.size());
		enfant = enfants.get(0);
		assertEquals("nom enfant correct", "Harrisson", enfant.getNom());
		assertEquals("prenom enfant correct", "George", enfant.getPrenom());
	}
	
	/*
	 * testSupprimerParent
	 */
	public void testSupprimerParent() {
		Famille famille = administrationBusiness.chercherFamille("00002");
		List<Parent> parents = administrationBusiness.chercherParents(famille);
		assertEquals("nombre de parents correct", 2, parents.size());
		
		Parent parent = parents.get(0);
		administrationBusiness.supprimerParent(famille, parent);
		
		//Vérification de la suppression
		famille = null;
		famille = administrationBusiness.chercherFamille("00002");
		parents = administrationBusiness.chercherParents(famille);
		assertEquals("nombre de parents correct", 1, parents.size());
		parent = parents.get(0);
		assertEquals("nom enfant correct", "McCartney", parent.getNom());
		assertEquals("prenom enfant correct", "Jim", parent.getPrenom());
	}
	
	/*
	 * testSupprimerFamille
	 */
	public void testSupprimerFamille() {
		Famille famille = administrationBusiness.chercherFamille("00002");
		administrationBusiness.supprimerFamille(famille);

		//Vérification de la suppression
		famille = null;
		famille = administrationBusiness.chercherFamille("00002");
		assertEquals("numCaf correct", null, famille);
	}
	
	/*
	 * Suite
	 */
	public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite("Test AdministrationBusiness");
        suite.addTest(new AdministrationBusinessTest("testAjouterNouvelleFamille"));
        suite.addTest(new AdministrationBusinessTest("testModifierFamille"));
        suite.addTest(new AdministrationBusinessTest("testAjouterEnfant"));
        suite.addTest(new AdministrationBusinessTest("testAjouterParent"));
        suite.addTest(new AdministrationBusinessTest("testSupprimerEnfant"));
        suite.addTest(new AdministrationBusinessTest("testSupprimerParent"));
        suite.addTest(new AdministrationBusinessTest("testSupprimerFamille"));
        return suite;
  }
	
}
