package fr.lesboutsdchou.reservations.dao.personnes.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.lesboutsdchou.reservations.dao.personnes.ParentDao;
import fr.lesboutsdchou.reservations.model.personnes.Enfant;
import fr.lesboutsdchou.reservations.model.personnes.Famille;
import fr.lesboutsdchou.reservations.model.personnes.Parent;

public class ParentDaoImpl extends HibernateDaoSupport implements ParentDao {


	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.ParentDao#addParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void addParent(Parent parent) {
		getHibernateTemplate().save(parent);
		//getSession().beginTransaction();
		//getSession().save(parent);
		//getSession().getTransaction().commit();
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.ParentDao#updateParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void updateParent(Parent parent) {
		getHibernateTemplate().update(parent);
		//getSession().beginTransaction();
		//getSession().update(parent);
		//getSession().getTransaction().commit();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.ParentDao#deleteParent(fr.lesboutsdchou.reservations.model.personnes.Parent)
	 */
	public void deleteParent(Parent parent) {
		getHibernateTemplate().delete(parent);
		//getSession().beginTransaction();
		//getSession().delete(parent);
		//getSession().getTransaction().commit();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.ParentDao#findAllParents()
	 */
	public List<Parent> findAllParents() {
		//getSession().beginTransaction();
		//List<Parent> parents = getSession().createQuery("from Parent").list();
		List<Parent> parents = getHibernateTemplate().find("from Parent");
		return parents;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.ParentDao#findAllParentsByEnfant(fr.lesboutsdchou.reservations.model.personnes.Enfant)
	 */
	public List<Parent> findAllParentsByEnfant(Enfant enfant) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.ParentDao#findAllParentsByFamille(fr.lesboutsdchou.reservations.model.personnes.Famille)
	 */
	public List<Parent> findAllParentsByFamille(Famille famille) {		
		List<Parent> parents = null;
		if(famille != null) {
			//getSession().beginTransaction();
			//parents = getSession().createQuery("select parent from " +
				//			"Famille as famille left join famille.parents parent where famille.numCaf = :numcaf").setString("numcaf", famille.getNumCaf()).list();
			parents = getHibernateTemplate().find("select parent from " +
					"Famille as famille left join famille.parents parent where famille.numCaf=?", famille.getNumCaf());
		}		
		//new String [] {catname, type}
		
		return parents;
		
	}
	/*
	 * (non-Javadoc)
	 * @see fr.lesboutsdchou.reservations.dao.personnes.ParentDao#findParentByNomPrenom(java.lang.String, java.lang.String)
	 */
	public List<Parent> findParentByNomPrenom(String nom, String prenom) {
		//getSession().beginTransaction();
		//List<Parent> parents = getSession().createQuery("from parent where parent.nom=:nom and parent.prenom=:prenom").setString("nom", nom).setString("prenom", prenom).list();
		List<Parent> parents = getHibernateTemplate().find("from parent where parent.nom=? and parent.prenom=?", new String [] {nom, prenom});
		return parents;
	}


}
