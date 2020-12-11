package it.lorenzomiscoli;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import it.lorenzomiscoli.entities.Role;
import it.lorenzomiscoli.entities.User;
import it.lorenzomiscoli.utils.JpaUtils;

public class App {
	
	public static void main(String[] args) {

		EntityManager em = null;
		EntityTransaction trx = null;

		try {

			JpaUtils jpaUtils = JpaUtils.getInstance();
			em = jpaUtils.getEntityManager();
			trx = em.getTransaction();
			trx.begin();
			User user = new User();
			user.setUsername("root");
			Role role = new Role();
			role.setName("ADMIN");
			em.persist(user);
			em.persist(role);
			user.addRole(role);
			em.flush();
			trx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trx.rollback();

		} finally {
			if (em != null) {
				em.close();
			}

		}

	}
	
}
