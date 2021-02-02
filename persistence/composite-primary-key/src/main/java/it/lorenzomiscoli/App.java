package it.lorenzomiscoli;

import javax.persistence.EntityManager;
import it.lorenzomiscoli.entities.Employee;
import it.lorenzomiscoli.entities.EmployeeId;
import it.lorenzomiscoli.entities.Language;
import it.lorenzomiscoli.entities.Task;
import it.lorenzomiscoli.entities.TaskId;
import it.lorenzomiscoli.entities.Translation;
import it.lorenzomiscoli.entities.TranslationId;
import it.lorenzomiscoli.utils.JpaUtils;

public class App {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			JpaUtils jpaUtils = JpaUtils.getInstance();
			em = jpaUtils.getEntityManager();
			Task task = em.find(Task.class, new TaskId("22VD14J", "test"));
			Employee employee = em.find(Employee.class, new EmployeeId(1L, 1L));
			Language language = new Language();
			language.setCode("ITA");
			Translation translation = em.find(Translation.class, new TranslationId(1L, language));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
