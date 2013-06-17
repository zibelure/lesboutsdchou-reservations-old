package fr.lesboutsdchou.reservations.dao.personnes.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.lesboutsdchou.reservations.dao.personnes.FamilleDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;

public class FamilleDaoImpl extends HibernateDaoSupport implements FamilleDao {

	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.FamilleDao#addFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void addFamille(Famille famille) {
		getHibernateTemplate().save(famille);
		//getSession().beginTransaction();
		//getSession().save(famille);
		//getSession().getTransaction().commit();
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.FamilleDao#updateFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void updateFamille(Famille famille) {
		getHibernateTemplate().update(famille);
		//getSession().beginTransaction();
		//getSession().update(famille);
		//getSession().getTransaction().commit();
		//this.sessionFactory.getCurrentSession().update(famille);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.FamilleDao#deleteFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public void deleteFamille(Famille famille) {
		getHibernateTemplate().delete(famille);
		//getSession().beginTransaction();
		//getSession().delete(famille);
		//getSession().getTransaction().commit();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.FamilleDao#findFamilleByNumcaf(java.lang.String)
	 */
	public Famille findFamilleByNumcaf(String numCaf) {
		//getSession().beginTransaction();
		List<Famille> familles = getHibernateTemplate().find("from Famille as famille where famille.numCaf=?", numCaf);
		//List<Famille> familles = getSession().createQuery("select famille from " +
				//"Famille as famille left join famille.parents parent where famille.numCaf=:numcaf").setString("numcaf", numCaf).list();
		//getSession().getTransaction().commit();
		//List<Famille> familles = getHibernateTemplate().find("select famille from Famille as famille left join famille.parents parent where famille.numCaf=?", numCaf);
		Famille famille = null;
		if(familles.size()>0) {
			famille = (Famille) familles.get(0);
		}
		return famille;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.FamilleDao#findAllFamilles()
	 */
	public List<Famille> findAllFamilles() {
		//getSession().beginTransaction();
		//List<Famille> familles = getSession().createQuery("from Famille").list();
		//getSession().getTransaction().commit();
		List<Famille> familles = getHibernateTemplate().find("from Famille");
		return familles;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.FamilleDao#findFamilleByEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public Famille findFamilleByEnfant(Enfant enfant) {		
		//getSession().beginTransaction();
		//List<Famille> familles = getSession().createQuery("select famille from " +
				//"Famille as famille left join famille.enfants enfant where enfant.id=:enfantid").setLong("enfantid", enfant.getId()).list();
		//getSession().getTransaction().commit();
		List<Famille> familles = getHibernateTemplate().find("select famille from Famille as famille left join famille.enfants enfant where enfant.id=?", enfant.getId());
		return (Famille) familles.get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.FamilleDao#findFamilleByParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public Famille findFamilleByParent(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
