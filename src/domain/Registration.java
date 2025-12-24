package domain;

public class Registration {
    private Student student;
    private Course course;
    private String term;

    public Registration(Student student, Course course, String term) {
        this.student = student;
        this.course = course;
        this.term = term;
    }
}
