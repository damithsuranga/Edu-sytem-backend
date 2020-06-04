package lk.edu.student.education.service.custom.impl;

import lk.edu.student.education.dto.CourseDTO;
import lk.edu.student.education.entity.Course;
import lk.edu.student.education.repository.CourseRepository;
import lk.edu.student.education.service.custom.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceimpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<CourseDTO> AllSubjects() {
        List<CourseDTO> Subjects = courseRepository.findAll().stream().map(course -> new CourseDTO(course.getSubjectCode(),
                course.getGrade(),course.getSubjects())).collect(Collectors.toList());
        return Subjects;
    }

    @Override
    public CourseDTO getSubejectBySubjectCode(String SubjectCode) {
        Course course = courseRepository.getOne(SubjectCode);
        CourseDTO courseDTO = new CourseDTO(course.getSubjectCode(),course.getGrade(),course.getSubjects());
        return courseDTO;
    }

    @Override
    public String uploadSubjects(CourseDTO courseDTO) {
        return courseRepository.save(new Course(courseDTO.getSubjectCode(),courseDTO.getGrade(),courseDTO.getSubjects())).getSubjectCode();
    }

    @Override
    public boolean isExistSubjectCode(String SubjectCode) {
       return courseRepository.existsById(SubjectCode);
    }
}
