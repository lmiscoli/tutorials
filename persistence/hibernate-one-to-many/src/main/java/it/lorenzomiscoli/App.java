package it.lorenzomiscoli;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import it.lorenzomiscoli.entities.Customer;
import it.lorenzomiscoli.entities.Order;
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
			Customer customer = new Customer();
			customer.getOrders().add(new Order());
			em.persist(customer);
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
