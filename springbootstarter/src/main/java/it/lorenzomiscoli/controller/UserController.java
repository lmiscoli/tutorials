package it.lorenzomiscoli.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import it.lorenzomiscoli.entity.User;
import it.lorenzomiscoli.exception.UserNotFoundException;
import it.lorenzomiscoli.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public Iterable findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/username/{username}")
	public List findByUsername(@PathVariable String username) {
		return userRepository.findByUsername(username);
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userRepository.findById(id).orElseThrow(UserNotFoundException::new);
		userRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public User update(@RequestBody User user, @PathVariable Long id) {
		userRepository.findById(id).orElseThrow(UserNotFoundException::new);
		return userRepository.save(user);
	}
}
