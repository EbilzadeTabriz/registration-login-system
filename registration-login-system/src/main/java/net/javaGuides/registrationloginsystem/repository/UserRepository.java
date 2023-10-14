package net.javaGuides.registrationloginsystem.repository;

import net.javaGuides.registrationloginsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
      User findByEmail(String email);
}
