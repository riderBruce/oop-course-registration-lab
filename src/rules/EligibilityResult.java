package rules;

public class EligibilityResult {
    private final boolean eligible;
    private final String message;

    private EligibilityResult(boolean eligible, String message){
        this.eligible = eligible;
        this.message = message;
    }

    public static EligibilityResult ok(String message){
        return new EligibilityResult(true, message);
    }
    public static EligibilityResult fail(String message) {
        return new EligibilityResult(false, message);
    }
    public boolean isEligible() {
        return eligible;
    }
    public String getMessage() {
        return message;
    }
}
