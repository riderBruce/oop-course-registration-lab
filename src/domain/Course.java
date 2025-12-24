package domain;

public class Course {
    private String courseId;
    private int requiredCredit;
    private Course prerequisiteCourse;

    public Course(String courseId, int requiredCredit, Course prerequisiteCourse) {
        this.courseId = courseId;
        this.requiredCredit = requiredCredit;
        this.prerequisiteCourse = prerequisiteCourse;
    }
    public String getCourseId() {        return courseId;    }
    public int getRequiredCredit(){
        return requiredCredit;
    }
    public Course getPrerequisiteCourse() {
        return prerequisiteCourse;
    }
}
