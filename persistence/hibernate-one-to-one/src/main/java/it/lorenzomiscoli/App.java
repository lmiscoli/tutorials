package it.lorenzomiscoli;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import it.lorenzomiscoli.entities.Employee;
import it.lorenzomiscoli.entities.EmployeeDetails;
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
			Employee employee = new Employee();
			EmployeeDetails employeeDetails = new EmployeeDetails();
			employee.setEmployeeDetails(employeeDetails);
			employeeDetails.setEmployee(employee);
			em.persist(employee);
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
