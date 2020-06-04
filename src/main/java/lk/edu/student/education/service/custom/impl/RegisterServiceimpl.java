package lk.edu.student.education.service.custom.impl;

import lk.edu.student.education.dto.RegisterDTO;
import lk.edu.student.education.dto.UserLoginDTO;
import lk.edu.student.education.entity.Register;
import lk.edu.student.education.repository.RegisterRepository;
import lk.edu.student.education.repository.UserLoginRepository;
import lk.edu.student.education.service.custom.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegisterServiceimpl implements RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    UserLoginRepository userLoginRepository;

    @Override
    public String saveStudent(RegisterDTO registerDTO) {
         return registerRepository.save(new Register(registerDTO.getUserName(),registerDTO.getPassWord(),registerDTO.getFirstName(),
                registerDTO.getLastName(),registerDTO.getEmail(),registerDTO.getAddress(),registerDTO.getPhoneNumber())).getUserName();
    }

    @Override
    public void updateStudent(RegisterDTO registerDTO) {
            registerRepository.saveAndFlush(new Register(registerDTO.getUserName(),registerDTO.getPassWord(),registerDTO.getFirstName(),
                    registerDTO.getLastName(),registerDTO.getEmail(),registerDTO.getAddress(),registerDTO.getPhoneNumber()));
    }

    @Override
    public boolean isStudentExists(String userName) {
        return registerRepository.existsById(userName);
    }

    @Override
    public List<RegisterDTO> getAllStudentList() {
        List<RegisterDTO> RegisterdStudents = registerRepository.findAll().stream().map(register -> new RegisterDTO(register.getUserName(),
                register.getPassWord(),register.getFirstName(),register.getLastName(),register.getEmail(),register.getAddress(),register.getPhoneNumber()
        )).collect(Collectors.toList());
        return RegisterdStudents;
    }

    @Override
    public RegisterDTO getStudentByUserName(String userName) {
        Register register = registerRepository.getOne(userName);
        RegisterDTO registerDTO = new RegisterDTO(register.getUserName(),register.getPassWord(),register.getFirstName(),register.getLastName(),
                register.getEmail(),register.getAddress(),register.getPhoneNumber());
        return registerDTO;
    }

    @Override
    public void removeStudent(String userName) {
            registerRepository.deleteById(userName);
    }

    @Override
    public List<RegisterDTO> StudentCount() {
        List<RegisterDTO> StudentCount = registerRepository.findAll().stream().map(register -> new RegisterDTO(register.getUserName(),register.getPassWord(),
                register.getFirstName(),register.getLastName(),register.getEmail(),register.getAddress(),register.getPhoneNumber()
        )).collect(Collectors.toList());
        return StudentCount;
    }
}
