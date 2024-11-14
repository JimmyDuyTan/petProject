package src.springboot.blog.elearns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.springboot.blog.elearns.entity.User;

public interface AdminRepository extends JpaRepository<User, Integer> {
}
