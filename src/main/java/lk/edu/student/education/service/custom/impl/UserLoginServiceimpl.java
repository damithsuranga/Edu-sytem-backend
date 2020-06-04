package lk.edu.student.education.service.custom.impl;

import lk.edu.student.education.dto.UserLoginDTO;
import lk.edu.student.education.entity.UserLogin;
import lk.edu.student.education.repository.UserLoginRepository;
import lk.edu.student.education.service.custom.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserLoginServiceimpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;


    @Override
    public UserLoginDTO getByUserNameforLogin(String userName) {
        UserLogin userLogin = userLoginRepository.getOne(userName);
        UserLoginDTO userLoginDTO = new UserLoginDTO(userLogin.getUserName(),userLogin.getPassWord());
        return userLoginDTO;
    }

    @Override
    public boolean isExistUserName(String userName) {
        return userLoginRepository.existsById(userName);
    }
}
