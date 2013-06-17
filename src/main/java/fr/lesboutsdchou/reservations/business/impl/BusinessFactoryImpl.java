package fr.lesboutsdchou.reservations.business.impl;

import org.springframework.context.ApplicationContext;

import fr.lesboutsdchou.reservations.business.AdministrationBusiness;
import fr.lesboutsdchou.reservations.business.BusinessFactory;
import fr.lesboutsdchou.reservations.business.ReservationBusiness;
import fr.lesboutsdchou.reservations.services.BeanFactory;

public class BusinessFactoryImpl implements BusinessFactory {
	
	private ApplicationContext context;
	private AdministrationBusiness administrationBusiness;
	private ReservationBusiness reservationBusiness;
	
	public void MetierFactoryImpl() {
		
		context  = BeanFactory.getInstance().getContext();
		
		administrationBusiness = (AdministrationBusinessImpl) context.getBean("administrationBusiness");
		reservationBusiness = (ReservationBusinessImpl) context.getBean("reservationBusiness");
		
		/*
		ReservationServices reservationServices = (ReservationServicesImpl) context.getBean("reservationServices"); //= new FamilleServicesImpl();
		AdresseServices adresseServices = (AdresseServicesImpl) context.getBean("adresseServices"); //= new FamilleServicesImpl();
		FamilleServices familleServices = (FamilleServicesImpl) context.getBean("familleServices"); //= new FamilleServicesImpl();
		EnfantServices enfantServices = (EnfantServicesImpl) context.getBean("enfantServices"); //= new FamilleServicesImpl();
		ParentServices ParentServices = (ParentServicesImpl) context.getBean("parentServices"); //= new FamilleServicesImpl();
		UtilisateurServices utilisateurServices = (UtilisateurServicesImpl) context.getBean("utilisateurServices"); //= new FamilleServicesImpl();
		*/
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.BusinessFactory#getContext()
	 */
	public ApplicationContext getContext() {
		return this.context;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.BusinessFactory#getAdministrationBusiness()
	 */
	public AdministrationBusiness getAdministrationBusiness() {
		return this.administrationBusiness;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.BusinessFactory#setAdministrationBusiness(fr.lesboutsdchou.reservations.business.AdministrationBusiness)
	 */
	public void setAdministrationBusiness(AdministrationBusiness administrationBusiness) {
		this.administrationBusiness = administrationBusiness;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.BusinessFactory#getReservationBusiness()
	 */
	public ReservationBusiness getReservationBusiness() {
		return this.reservationBusiness;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.business.BusinessFactory#setReservationBusiness(fr.lesboutsdchou.reservations.business.ReservationBusiness)
	 */
	public void setReservationBusiness(ReservationBusiness reservationBusiness) {
		this.reservationBusiness = reservationBusiness;
		
	}
	

}
