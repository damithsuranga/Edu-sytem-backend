package lk.edu.student.education.controller;

import lk.edu.student.education.dto.UserLoginDTO;
import lk.edu.student.education.service.custom.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/vi/login")
@RestController
public class UserLoginController {

    @Autowired
    public UserLoginService userLoginService;

    @GetMapping(value = "/{userLogin}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserLoginDTO> getUserName(@PathVariable("userLogin") String userName, @RequestBody UserLoginDTO userLoginDTO){
       if(userLoginService.isExistUserName(userName)){
            userLoginDTO = userLoginService.getByUserNameforLogin(userName);
           System.out.println(userName);
       }
        return new ResponseEntity<UserLoginDTO>(userLoginDTO ,(userLoginDTO != null) ? HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

}
