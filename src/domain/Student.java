package domain;

public class Student extends Person {
    private int completedCredits;
    private Course courseTaken;

    public Student(String id, String name, int completedCredits, Course courseTaken) {
        super(id, name);
        this.completedCredits = completedCredits;
        this.courseTaken = courseTaken;
    }

    public int getCompletedCredits(){
        return completedCredits;
    }
    public Course getCourseTaken(){
        return courseTaken;
    }

    @Override
    public String getRole() {
        return "domain.Student";
    }
}
