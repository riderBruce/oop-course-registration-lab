package rules;

import domain.Course;
import domain.RegistrationRecord;
import domain.Student;
import infra.FileHandler;
import infra.FileHandlerException;

import java.util.List;

public class AlreadyRegisteredRule implements EligibilityRule {

    private final FileHandler fileHandler;
    private final Course course;
    private final String term;

    public AlreadyRegisteredRule(FileHandler fileHandler, Course course, String term) {
        this.fileHandler = fileHandler;
        this.course = course;
        this.term = term;
    }

    @Override
    public EligibilityResult evaluate(Student student) {

        List<RegistrationRecord> records = fileHandler.loadRecords();

        boolean alreadyRegistered = records.stream()
                .anyMatch(r ->
                        r.getStudentId().equals(student.getId()) &&
                        r.getCourseId().equals(course.getCourseId()) &&
                        r.getTerm().equals(term)
                );

        if (alreadyRegistered) {
            return EligibilityResult.fail("Already registered for this course in this term");
        }
        return EligibilityResult.ok("Not registered yet. OK.");
    }
}
