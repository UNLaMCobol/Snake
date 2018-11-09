package ar.com.cobol.hibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ar.com.cobol.database.DataBase;

public class UsuarioController extends DataBase {
	
	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

	public static boolean loguearUsuario(Usuario cli) {
		Session session = crearSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
			Root<Usuario> rp = cq.from(Usuario.class);
			cq.select(rp).where(cb.like(rp.get("user"), cli.getUser()));
			Usuario ue = session.createQuery(cq).getSingleResult();
			if (ue.getPassword().equals(cli.getPassword()))
				return true;
			else
				return false;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();			
			e.printStackTrace();
			return false;
		} finally {
			session.close();	
		}	
	}

	public static boolean puedoRegistrarUsuario(Usuario cli) {
		Session session = crearSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
			Root<Usuario> rp = cq.from(Usuario.class);
			cq.select(rp).where(cb.like(rp.get("user"), cli.getUser()));
			Usuario ue = session.createQuery(cq).getSingleResult();
			if (!ue.getUser().equals(cli.getUser()))
				return true;
			else
				return false;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();			
			e.printStackTrace();
			return true;
		} finally {
			session.close();	
		}	
	}

	public static void registrarUsuario(Usuario cli) {
		Session session = crearSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(new Usuario(cli.getUser(), cli.getPassword()));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();			
			e.printStackTrace();
		} finally {
			session.close();	
		}	
	}
	
}
