import domain.Course;
import domain.RegistrationRecord;
import domain.Student;
import infra.FileHandler;
import rules.EligibilityResult;
import services.RegistrationService;

public class Main {
    public static void main(String[] args){
        Course csis1280 = new Course("CSIS1280", 0, null);
        Course csis3380 = new Course("CSIS3380", 15, csis1280);
        Student young = new Student("30012342567", "Young", 12, csis1280);

        FileHandler file = new FileHandler();
        RegistrationService service = new RegistrationService(file);

        registerDemo(service, young, csis1280, "2026Winter");
        registerDemo(service, young, csis3380, "2026Winter");

        System.out.println("\n=== Saved Registrations ===");
        for (RegistrationRecord record : file.loadRecords()) {
            System.out.println(record);
        }
    }
    public static void registerDemo(
            RegistrationService service,
            Student student,
            Course course,
            String term
    ) {

        EligibilityResult result = service.registerAndSave(student, course, term);
        if (!result.isEligible()){
            System.out.println("Register denied (" + course.getCourseId() + "): " + result.getMessage());
            return;
        }
        System.out.println("Registered (" + course.getCourseId() + "): " + result.getMessage());
    }
}
