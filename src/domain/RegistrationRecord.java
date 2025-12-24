package domain;

public class RegistrationRecord {

    private final String studentId;
    private final String courseId;
    private final String term;

    public RegistrationRecord(String studentId, String courseId, String term) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.term = term;
    }

    public String getStudentId() {
        return studentId;
    }
    public String getCourseId() {
        return courseId;
    }
    public String getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return studentId + "," + courseId + "," + term;
    }
}
