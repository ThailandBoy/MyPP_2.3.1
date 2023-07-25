package ru.chuldum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chuldum.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
