package lk.edu.student.education.repository;

import lk.edu.student.education.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin,String> {
}
