package lk.edu.student.education.controller;

import lk.edu.student.education.dto.CourseDTO;
import lk.edu.student.education.service.custom.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("api/vi/Course")
@RestController
public class CourseDetailsController {


    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/{UploadCourse}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> UploadCourse(@PathVariable("UploadCourse") String SubjectCode,@RequestBody CourseDTO courseDTO){
             courseService.uploadSubjects(courseDTO);
            return new ResponseEntity<String>(SubjectCode,HttpStatus.OK);
    }

    @GetMapping(value = "/{Subjects}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> SubjectsInGrade(){
        return courseService.AllSubjects();
    }


    @GetMapping(value = "/{subjectCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseDTO> SubjectDetails(@PathVariable("subjectCode") String subjectCode,@RequestBody CourseDTO courseDTO){
        if(courseService.isExistSubjectCode(subjectCode)){
            courseDTO = courseService.getSubejectBySubjectCode(subjectCode);
        }
        return new ResponseEntity<CourseDTO>(courseDTO,(courseDTO != null)?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }


}
