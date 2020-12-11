package it.lorenzomiscoli.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static JpaUtils _instance = null;
	private EntityManagerFactory emfactory = null;

	private JpaUtils() {

		emfactory = Persistence.createEntityManagerFactory("jpaTest");
	}

	public static synchronized JpaUtils getInstance() {

		if (_instance == null) {
			_instance = new JpaUtils();
		}
		return _instance;
	}

	public EntityManager getEntityManager() {
		return emfactory.createEntityManager();
	}
}
