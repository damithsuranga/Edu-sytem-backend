package lk.edu.student.education.service.custom;

import lk.edu.student.education.dto.RegisterDTO;
import lk.edu.student.education.service.SuperService;

import java.util.List;

public interface RegisterService extends SuperService {


    String saveStudent(RegisterDTO registerDTO);

    public void updateStudent(RegisterDTO registerDTO);

    boolean isStudentExists(String userName);

    public List<RegisterDTO> getAllStudentList();

    public RegisterDTO getStudentByUserName(String userName);

    public void removeStudent(String userName);

    public List<RegisterDTO> StudentCount();


}
