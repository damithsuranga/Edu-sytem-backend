package lk.edu.student.education.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLogin {

    @Id
    private String userName;
    private String passWord;

    public UserLogin() {
    }

    public UserLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
