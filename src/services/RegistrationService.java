package services;

import domain.Course;
import domain.RegistrationRecord;
import domain.Student;
import factory.RegistrationFactory;
import infra.FileHandler;
import infra.FileHandlerException;
import rules.*;

import java.util.List;

public class RegistrationService {
    private final FileHandler file;

    public RegistrationService(FileHandler file) {
        this.file = file;
    }

    public EligibilityResult registerAndSave(
            Student student,
            Course course,
            String term
    ) {
        List<EligibilityRule> rules = buildRules(course, term);

        EligibilityResult result = RegistrationFactory.create(student, course, term, rules);

        if (result.isEligible()) {
            RegistrationRecord record = new RegistrationRecord(student.getId(), course.getCourseId(), term);
            file.save(record);
        }

        return result;
    }

    private List<EligibilityRule> buildRules(Course course, String term) {

        return List.of(
                new AlreadyRegisteredRule(file, course, term),
                new CreditRule(course.getRequiredCredit()),
                new PrerequisiteRule(course.getPrerequisiteCourse())
        );
    }
}
