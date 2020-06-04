package lk.edu.student.education.controller;

import lk.edu.student.education.dto.RegisterDTO;
import lk.edu.student.education.service.custom.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RequestMapping("api/vi/student")
@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/{Register}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveStudent(@PathVariable("Register") String userName,@RequestBody RegisterDTO registerDTO){
        if(userName.equals(registerDTO.getUserName())){
            System.out.println("User Name");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        if(registerDTO.getUserName().isEmpty()||registerDTO.getPassWord().isEmpty()||registerDTO.getFirstName().isEmpty()
        ||registerDTO.getLastName().isEmpty()||registerDTO.getEmail().isEmpty()||registerDTO.getAddress().isEmpty()||registerDTO.getPhoneNumber().isEmpty()){
          System.out.println("registerDTO");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        else {
              registerService.saveStudent(registerDTO);
                return new ResponseEntity<String>(HttpStatus.CREATED);


       }
    }

    @PutMapping(path = "/{userName}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStudent(@PathVariable("userName") String userName,@RequestBody RegisterDTO registerDTO){
//        if(userName.equals(registerDTO.getUserName())){
//            System.out.println("User Name");
//            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//        }
        if(registerDTO.getFirstName().isEmpty()||registerDTO.getLastName().isEmpty()||registerDTO.getEmail().isEmpty()||registerDTO.getAddress().isEmpty()||registerDTO.getPhoneNumber().isEmpty()){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else {
            registerDTO.setUserName(userName);
            registerService.updateStudent(registerDTO);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/{RegisterdStudents}")
    public List<RegisterDTO> AllStudents(){
        return registerService.getAllStudentList();
    }

    @GetMapping(value = "/{userName}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterDTO> getStudent(@PathVariable("userName") String userName, @RequestBody RegisterDTO registerDTO){
        if(registerService.isStudentExists(userName)){
            registerDTO = registerService.getStudentByUserName(userName);
            System.out.println(userName);
        }
        return new ResponseEntity<RegisterDTO>(registerDTO, (registerDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{userName}")
    public ResponseEntity<Void> deleteByUserName(@PathVariable("userName") String userName){
        if(!registerService.isStudentExists(userName)){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        registerService.removeStudent(userName);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value = "/{count}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegisterDTO>> AllStudentsCount(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Student-Count",registerService.StudentCount()+"");
        httpHeaders.setAccessControlAllowHeaders(Arrays.asList("Student-Count"));
        httpHeaders.setAccessControlExposeHeaders(Arrays.asList("Student-Count"));
        System.out.println(httpHeaders);
        return new ResponseEntity<List<RegisterDTO>>(registerService.StudentCount(),HttpStatus.OK);
    }

}
