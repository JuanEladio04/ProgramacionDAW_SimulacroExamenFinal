package jepm.proyect.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jepm.proyect.model.Municipio;


public class MunicipioController {
	
	private static MunicipioController instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static MunicipioController getInstance() {
		if (instance == null) {
			instance = new MunicipioController();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param string
	 */
	public static List<Municipio> findbyId(int idProvincia) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinalSimulacro");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Municipio> m = new ArrayList<Municipio>();
				
		Query q = em.createNativeQuery("SELECT * FROM municipio where idProvincia = ?", Municipio.class);

		q.setParameter(1, idProvincia);

		
		try {
			m = (List<Municipio>) q.getResultList();
		} catch (Exception e) {
			m = null;
		}
		em.close();		
		return m;
		
	}

}
