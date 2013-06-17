package fr.lesboutsdchou.reservations.dao.personnes.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.lesboutsdchou.reservations.dao.personnes.AdresseDao;
import fr.lesboutsdchou.reservations.model.personnes.Adresse;
import fr.lesboutsdchou.reservations.model.personnes.Famille;

public class AdresseDaoImpl extends HibernateDaoSupport implements AdresseDao {
    
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.AdresseDao#addAdresse(fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void addAdresse(Adresse adresse) {
		getHibernateTemplate().save(adresse);
		//getSession().beginTransaction();
		//getSession().save(adresse);
		//getSession().getTransaction().commit();
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.AdresseDao#updateAdresse(fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void updateAdresse(Adresse adresse) {
		getHibernateTemplate().update(adresse);
		//getSession().beginTransaction();
		//getSession().update(adresse);
		//getSession().getTransaction().commit();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.AdresseDao#deleteAdresse(fr.lesboutsdchou.reservations.model.personnes.Adresse)
	 */
	public void deleteAdresse(Adresse adresse) {
		getHibernateTemplate().delete(adresse);
		//getSession().beginTransaction();
		//getSession().delete(adresse);
		//getSession().getTransaction().commit();
	}
	

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.AdresseDao#findAdresseByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public Adresse findAdresseByFamille(Famille famille) {
		List<Adresse> adresses = getHibernateTemplate().find("from famille as fam, adresse as adr, adresses_famille as par_fam " +
				"where " +
				"par_fam.id_famille = fam.id_famille and par_fam.id_parent = enf.id_parent " +
				"and fam.numcaf=?", famille.getNumCaf());
		//getSession().beginTransaction();
		//List<Adresse> adresses = getSession().createQuery(
				//"from famille as fam, adresse as adr, adresses_famille as par_fam " +
				//"where " +
				//"par_fam.id_famille = fam.id_famille and par_fam.id_parent = enf.id_parent " +
				//"and fam.numcaf=:numcaf").setString("numcaf", famille.getNumCaf()).list();
		return adresses.get(0);
	}


}
