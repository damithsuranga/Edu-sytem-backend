package lk.edu.student.education.service.custom;

import lk.edu.student.education.dto.UserLoginDTO;
import lk.edu.student.education.service.SuperService;

public interface UserLoginService extends SuperService {

    public UserLoginDTO getByUserNameforLogin(String userName);

    boolean isExistUserName(String userName);

}
