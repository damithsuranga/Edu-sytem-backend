package lk.edu.student.education.repository;

import lk.edu.student.education.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,String> {
}
