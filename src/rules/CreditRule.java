package rules;

import domain.Student;

public class CreditRule implements EligibilityRule {
    private final int requiredCredits;

    public CreditRule(int requiredCredits) {
        this.requiredCredits = requiredCredits;
    }

    @Override
    public EligibilityResult evaluate(Student student) {
        if (student.getCompletedCredits() >= requiredCredits) {
            return EligibilityResult.ok("Credit requirement satisfied.");
        }
        return EligibilityResult.fail("Insufficient credits.");
    }
}
