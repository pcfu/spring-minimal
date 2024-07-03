package com.sephora.fuel.springminimal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.sephora.fuel.springminimal.entity.UserEntity;
import com.sephora.fuel.springminimal.repository.UserRepository;
import com.sephora.fuel.springminimal.exception.RecordNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {

    private UserRepository repo;

    @Autowired
    public UserController(UserRepository repo) {
        this.repo = repo;
    }

	@GetMapping("users")
	public List<UserEntity> getUsers() {
		return repo.findAll();
	}

	@GetMapping("users/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND) // Not suitable because response does not behave in a consistent way
	public UserEntity getUser(@PathVariable Long id) {
		Optional<UserEntity> res = repo.findById(id);
        if (res.isPresent()) {
            return res.get();
        }

        return null;
	}

	@GetMapping("users/betterresponse/{id}")
	public ResponseEntity<UserEntity> getUserWithResponseEntity(@PathVariable Long id) {
		Optional<UserEntity> res = repo.findById(id);
        if (res.isPresent()) {
            return ResponseEntity.ok().header("My-Custom-Header", "yaay!").body(res.get());
        }

        return ResponseEntity.notFound().header("My-Custom-Header", "what an idiot!").build();
	}

	@GetMapping("users/errorhandling/{id}")
	public UserEntity getUserWithErrorHandling(@PathVariable Long id) {
		Optional<UserEntity> res = repo.findById(id);
        if (res.isPresent()) {
            return res.get();
        }

        throw new RecordNotFoundException("User", id);
	}
}
