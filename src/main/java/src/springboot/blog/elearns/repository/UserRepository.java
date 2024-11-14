package src.springboot.blog.elearns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import src.springboot.blog.elearns.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
