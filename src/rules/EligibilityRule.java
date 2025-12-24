package rules;

import domain.Student;

public interface EligibilityRule {
    EligibilityResult evaluate(Student student);
}
