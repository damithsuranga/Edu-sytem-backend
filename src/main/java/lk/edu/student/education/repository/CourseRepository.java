package lk.edu.student.education.repository;

import lk.edu.student.education.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
