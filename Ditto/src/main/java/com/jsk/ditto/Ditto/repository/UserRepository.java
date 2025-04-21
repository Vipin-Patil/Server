package com.jsk.ditto.Ditto.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jsk.ditto.Ditto.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
