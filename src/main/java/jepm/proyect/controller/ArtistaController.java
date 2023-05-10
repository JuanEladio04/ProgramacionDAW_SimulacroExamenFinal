package jepm.proyect.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jepm.proyect.model.Artista;


public class ArtistaController {
	
	private static ArtistaController instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static ArtistaController getInstance() {
		if (instance == null) {
			instance = new ArtistaController();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Artista> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalSimulacro");	
		EntityManager em = entityManagerFactory.createEntityManager();
	    TypedQuery<Artista> query = em.createNamedQuery("Artista.findAll", Artista.class);
	    return query.getResultList();
	}
	
	
	/**
	 * 
	 */
	public static List<Artista> findByLikeDescription (String description) {
		List<Artista> artistas = new ArrayList<Artista>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalSimulacro");

		EntityManager em = entityManagerFactory.createEntityManager();

	    Query q = em.createNativeQuery("SELECT * FROM artista where nombre LIKE ?", Artista.class);
	    q.setParameter(1, "%" + description + "%");

	    artistas.addAll(q.getResultList());
	    
	    em.close();

	    return artistas;
		
	}
	
	
	
	/**
	 * 
	 */
	public static void realizeUpdate (Artista e) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalSimulacro");

		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}


}
