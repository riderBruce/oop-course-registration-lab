package factory;

import domain.Course;
import domain.Registration;
import domain.Student;
import rules.EligibilityResult;
import rules.EligibilityRule;

import java.util.List;

public class RegistrationFactory {
    public static EligibilityResult create(
            Student student,
            Course course,
            String term,
            List<EligibilityRule> rules
    ) {
        for (EligibilityRule rule: rules) {
            EligibilityResult result = rule.evaluate(student);
            if (!result.isEligible()) {
                return result;
            }
        }
        Registration reg = new Registration(student, course, term);
        return EligibilityResult.ok("domain.Registration successful.");
    }
}
