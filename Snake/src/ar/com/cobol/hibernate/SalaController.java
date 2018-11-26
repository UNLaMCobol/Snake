package ar.com.cobol.hibernate;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ar.com.cobol.database.DataBase;
import ar.com.cobol.sala.UsuarioSala;
import ar.com.cobol.sala.UsuarioSalaController;


public class SalaController {
	
	public static boolean CrearSala(int idCreador,Sala sala) {
		Session session = DataBase.crearSession();
		
		Sala salaExistente = exists(sala.getNombre(), session);
		if(salaExistente != null)
			return false;
		
		Transaction tx = session.beginTransaction();
		try {			
			session.save(sala);			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				session.close();	
				return false;
			}							
			
		}	
		
		UsuarioSalaController.agregarParticipanteSala(idCreador,sala);
		
		session.close();
		return true;
	}	
	
	
	public static boolean invitarSala(String nombreUsuario,String nombreSala) {
		Session session = DataBase.crearSession();
		
		Sala salaExistente = exists(nombreSala, session);
		if(salaExistente == null)
			return false;
		
		
		Usuario usuarioExistente = UsuarioSalaController.obtenerPorNombre(nombreUsuario, session);
		
		if(usuarioExistente == null)
			return false;
		
		Transaction tx = session.beginTransaction();
		UsuarioSala invitacion= new UsuarioSala();
		invitacion.setIdSala(salaExistente.getId());
		invitacion.setIdUsuario(usuarioExistente.getId());
		try {			
			session.save(invitacion);			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				session.close();	
				return false;
			}							
			
		}		
		session.close();
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static Sala exists (String nombreSala,Session sesion) {	
		Sala sala = null;		
		try {
			
			Query q = sesion.createNativeQuery("select * from sala ua"
					+ " where nombre = '" + nombreSala + "'" , Sala.class);		  	
			
			try{ 
				sala  =(Sala) q.uniqueResult();
			}	
			catch (NoResultException nre){
				//Se evita que termine la ejecuci�n si no se encuentra el registro
			}						
        } catch (HibernateException e) {
            e.printStackTrace();
        } 
		
		return sala;		
	}

}
