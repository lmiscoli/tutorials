package it.lorenzomiscoli.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.lorenzomiscoli.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByUsername(String username);
}
