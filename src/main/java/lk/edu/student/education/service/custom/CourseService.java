package lk.edu.student.education.service.custom;

import lk.edu.student.education.dto.CourseDTO;
import lk.edu.student.education.service.SuperService;

import java.util.List;

public interface CourseService extends SuperService {

    public List<CourseDTO> AllSubjects();

    public CourseDTO getSubejectBySubjectCode(String SubjectCode);

    String uploadSubjects(CourseDTO courseDTO);

    boolean isExistSubjectCode(String SubjectCode);


}
