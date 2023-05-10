package jepm.proyect.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jepm.proyect.model.Artista;
import jepm.proyect.model.Disciplina;
import jepm.proyect.model.Municipio;

public class DisciplinaController {

	private static DisciplinaController instance = null;

	/**
	 * 
	 * @return
	 */
	public static DisciplinaController getInstance() {
		if (instance == null) {
			instance = new DisciplinaController();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public static Disciplina findByLikeDescription (String description) {
		Disciplina disciplina = new Disciplina();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalSimulacro");

		EntityManager em = entityManagerFactory.createEntityManager();

	    Query q = em.createNativeQuery("SELECT * FROM disciplina where descripcion LIKE ?", Disciplina.class);
	    q.setParameter(1, "%" + description + "%");

	    disciplina = (Disciplina) q.getSingleResult();
	    
	    em.close();

	    return disciplina;
		
	}
	

}
