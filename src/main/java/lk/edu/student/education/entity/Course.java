package lk.edu.student.education.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String SubjectCode;
    private String Grade;
    private String Subjects;

    public Course(String subjectCode, String grade, String subjects) {
        this.SubjectCode = subjectCode;
        this.Grade = grade;
        this.Subjects = subjects;
    }

    public Course() {
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        SubjectCode = subjectCode;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getSubjects() {
        return Subjects;
    }

    public void setSubjects(String subjects) {
        Subjects = subjects;
    }

    @Override
    public String toString() {
        return "Course{" +
                "SubjectCode='" + SubjectCode + '\'' +
                ", Grade='" + Grade + '\'' +
                ", Subjects='" + Subjects + '\'' +
                '}';
    }
}
