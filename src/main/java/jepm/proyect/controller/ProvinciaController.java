package jepm.proyect.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jepm.proyect.model.Artista;
import jepm.proyect.model.Provincia;

public class ProvinciaController {
	
	private static ProvinciaController instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static ProvinciaController getInstance() {
		if (instance == null) {
			instance = new ProvinciaController();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Provincia> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalSimulacro");	
		EntityManager em = entityManagerFactory.createEntityManager();
	    TypedQuery<Provincia> query = em.createNamedQuery("Provincia.findAll", Provincia.class);
	    return query.getResultList();
	}

}
