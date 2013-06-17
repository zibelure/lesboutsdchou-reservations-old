import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;

import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.services.BeanFactory;
import fr.lesboutsdchou.reservations.services.personnes.AdresseServices;
import fr.lesboutsdchou.reservations.services.personnes.EnfantServices;
import fr.lesboutsdchou.reservations.services.personnes.FamilleServices;
import fr.lesboutsdchou.reservations.services.personnes.ParentServices;
import fr.lesboutsdchou.reservations.services.personnes.impl.AdresseServicesImpl;
import fr.lesboutsdchou.reservations.services.personnes.impl.EnfantServicesImpl;
import fr.lesboutsdchou.reservations.services.personnes.impl.FamilleServicesImpl;
import fr.lesboutsdchou.reservations.services.personnes.impl.ParentServicesImpl;
import fr.lesboutsdchou.reservations.services.planning.ReservationServices;
import fr.lesboutsdchou.reservations.services.planning.impl.ReservationServicesImpl;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context  = BeanFactory.getInstance().getContext();
		
		//ReservationDao reservationDao = (ReservationDaoImpl) context.getBean("reservationDao");
		ReservationServices reservationServices = (ReservationServicesImpl) context.getBean("reservationServices"); //= new FamilleServicesImpl();
		AdresseServices adresseServices = (AdresseServicesImpl) context.getBean("adresseServices"); //= new FamilleServicesImpl();
		FamilleServices familleServices = (FamilleServicesImpl) context.getBean("familleServices"); //= new FamilleServicesImpl();
		EnfantServices enfantServices = (EnfantServicesImpl) context.getBean("enfantServices"); //= new FamilleServicesImpl();
		ParentServices ParentServices = (ParentServicesImpl) context.getBean("parentServices"); //= new FamilleServicesImpl();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		Famille famille = new Famille();
		famille.setNumCaf("00001");
		
		
		Enfant enfant = new Enfant();
		enfant.setNom("Lennon");
		enfant.setPrenom("John");
		Adresse adresse = new Adresse();
		adresse.setVoie("Dakota Building");
		adresse.setNumVoie("1");
		adresse.setCodePostal("91000");
		adresse.setLocalite("New York");
		enfant.setAdresse(adresse);
		famille.setAdresse(adresse);
		
		
		List<Enfant> enfants = new ArrayList<Enfant>();
		enfants.add(enfant);
		famille.setEnfants(enfants);
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(2012, 12, 24, 9, 30, 00);
		gc.set(2012, 12, 24, 16, 30, 00);
		
		Date dateNaissance = null;
		Date dateHeureDebut = null;
		Date dateHeureFin = null;
		try {
			dateNaissance = simpleDateFormat.parse("17/06/2010 00:00:00");
			dateHeureDebut = simpleDateFormat.parse("24/12/2012 09:00:00");
			dateHeureFin = simpleDateFormat.parse("24/12/2012 16:30:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		enfant.setDateNaissance(dateNaissance);
		enfant.setDateCreation(new Date());
		//
//		adresseServices.addAdresse(adresse);
		//
		familleServices.addFamille(famille);
		//
//		Famille familleTrouvee = familleServices.findFamilleByNumcaf("00001");
		//
//		enfantServices.addEnfantForFamille(enfant, familleTrouvee);
		//
		//reservationServices.addReservation(enfant, dateHeureDebut, dateHeureFin);

	}

}
