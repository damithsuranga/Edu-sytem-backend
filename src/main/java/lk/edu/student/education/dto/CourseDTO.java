package lk.edu.student.education.dto;

public class CourseDTO {

    private String SubjectCode;
    private String Grade;
    private String Subjects;

    public CourseDTO(String subjectCode, String grade, String subjects) {
        this.SubjectCode = subjectCode;
        this.Grade = grade;
        this.Subjects = subjects;
    }

    public CourseDTO() {
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
        return "CourseDTO{" +
                "SubjectCode='" + SubjectCode + '\'' +
                ", Grade='" + Grade + '\'' +
                ", Subjects='" + Subjects + '\'' +
                '}';
    }
}
