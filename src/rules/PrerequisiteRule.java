package rules;

import domain.Course;
import domain.Student;

public class PrerequisiteRule implements EligibilityRule {
    private Course prerequisiteCourse;

    public PrerequisiteRule(Course prerequisiteCourse) {
        this.prerequisiteCourse = prerequisiteCourse;
    }

    @Override
    public EligibilityResult evaluate(Student student) {
        if (this.prerequisiteCourse == null) {
            return EligibilityResult.ok("No pre-requisite course");
        }
        if (this.prerequisiteCourse == student.getCourseTaken()) {
            return EligibilityResult.ok("Pre-requisite course satisfied.");
        }
        return EligibilityResult.fail("Insufficient pre-requisite course.");
    }
}
