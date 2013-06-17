package fr.lesboutsdchou.reservations.business;

import org.springframework.context.ApplicationContext;

public interface BusinessFactory {
	
	public ApplicationContext getContext();
	
	public AdministrationBusiness getAdministrationBusiness();
	
	public void setAdministrationBusiness(AdministrationBusiness administrationBusiness);

	public ReservationBusiness getReservationBusiness();
	
	public void setReservationBusiness(ReservationBusiness reservationBusiness);

}
