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
import fr.lesboutsdchou.reservations.business.ReservationBusiness;
import fr.lesboutsdchou.reservations.business.impl.BusinessFactoryImpl;
import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;
import fr.lesboutsdchou.reservations.model.planning.CreneauReserve;
import fr.lesboutsdchou.reservations.services.BeanFactory;

/**
 * @author anadot
 *
 */
public class ReservationBusinessTest extends TestCase {
	
	ApplicationContext context;
	BusinessFactory businessFactory;
	ReservationBusiness reservationBusiness;
	AdministrationBusiness administrationBusiness;
	SimpleDateFormat simpleDateFormat;
	
	/*
	 * 
	 */
	public ReservationBusinessTest(String reservationBusiness) {
		super(reservationBusiness);
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
		reservationBusiness = businessFactory.getReservationBusiness();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	}
	

	/*
	 * ajouterNouvellesFamilles
	 */
	private void ajouterNouvellesFamilles() {
		Famille famille = new Famille();
		famille.setNumCaf("00003");
		
		//Ajout adresse
		Adresse adresse = new Adresse();
		adresse.setVoie("Peny Lane");
		adresse.setNumVoie("1");
		adresse.setCodePostal("90000");
		adresse.setLocalite("Liverpool");

		//Ajout enfants
		Enfant enfant = new Enfant();
		enfant.setNom("Starkey");
		enfant.setPrenom("Richard");
		enfant.setAdresse(adresse);
		famille.setAdresse(adresse);
		List<Enfant> enfants = new ArrayList<Enfant>();
		enfants.add(enfant);
		famille.setEnfants(enfants);
			
		//Ajout parents
		Parent parent = new Parent();
		parent.setNom("Starkey");
		parent.setPrenom("Magnus");
		parent.setAdresse(adresse);
		List<Parent> parents = new ArrayList<Parent>();
		parents.add(parent);
		famille.setParents(parents);


		//Gestion des dates
		Date dateNaissanceEnfant = null;
		Date dateNaissanceParent = null;
		try {
			dateNaissanceEnfant = simpleDateFormat.parse("25/11/2010 00:00:00");
			dateNaissanceParent = simpleDateFormat.parse("09/02/1970 00:00:00");
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
		
		famille = new Famille();
		famille.setNumCaf("00004");
		
		//Ajout adresse
		adresse = new Adresse();
		adresse.setVoie("Dakota Building");
		adresse.setNumVoie("1");
		adresse.setCodePostal("91000");
		adresse.setLocalite("New York");

		//Ajout enfants
		enfant = new Enfant();
		enfant.setNom("Lennon");
		enfant.setPrenom("John");
		enfant.setAdresse(adresse);
		famille.setAdresse(adresse);
		enfants = new ArrayList<Enfant>();
		enfants.add(enfant);
		famille.setEnfants(enfants);
			
		//Ajout parents
		parent = new Parent();
		parent.setNom("Mimi");
		parent.setPrenom("Aunt");
		parent.setAdresse(adresse);
		parents = new ArrayList<Parent>();
		parents.add(parent);
		famille.setParents(parents);


		//Gestion des dates
		dateNaissanceEnfant = null;
		dateNaissanceParent = null;
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
		
	}
	
	/*
	 * testAjouterNouvellesReservations
	 */
	public void testAjouterNouvellesReservations() {
		
		ajouterNouvellesFamilles();
		
		Famille famille = administrationBusiness.chercherFamille("00003");
		List<Enfant> enfants = administrationBusiness.chercherEnfants(famille);	
		Enfant enfant = null;
		if (enfants != null) {
			enfant = enfants.get(0);
		}
		//Gestion des dates
		Date dateHeureDebut = null;
		Date dateHeureFin = null;
		try {
			dateHeureDebut = simpleDateFormat.parse("17/03/2013 09:00:00");
			dateHeureFin = simpleDateFormat.parse("17/03/2013 16:30:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//Ajout de la nouvelle réservation
		CreneauReserve creneau = new CreneauReserve();
		creneau.setFamille(famille);
		creneau.setEnfant(enfant);
		creneau.setDateHeureDebut(dateHeureDebut);
		creneau.setDateHeureFin(dateHeureFin);
		reservationBusiness.reserver(creneau);
		
		//Vérification de l'ajout
		creneau = reservationBusiness.rechercherReservationsParEnfantParJour(famille, enfant, dateHeureDebut);
		assertEquals("date créneau correcte", dateHeureDebut, creneau.getDateHeureDebut());
		assertEquals("enfant créneau correct", enfant, creneau.getEnfant());
		
	}
	
	
	/*
	 * testModifierReservation
	 */
	public void testModifierReservation() {
		
		
	}
	
	
	/*
	 * testSupprimerReservation
	 */
	public void testSupprimerReservation() {

	}
	
	
	
	/*
	 * Suite
	 */
	public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite("Test AdministrationBusiness");
        suite.addTest(new ReservationBusinessTest("testAjouterNouvellesReservations"));
        //suite.addTest(new ReservationBusinessTest("testModifierReservation"));
        //suite.addTest(new ReservationBusinessTest("testSupprimerReservation"));
        return suite;
  }
	
}
