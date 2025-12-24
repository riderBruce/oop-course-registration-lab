package test;

import static org.junit.jupiter.api.Assertions.*;

import domain.RegistrationRecord;
import infra.FileHandler;
import infra.FileHandlerException;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHandlerTest {

    @Test
    void save_throws_exception_when_target_is_a_directory() {

        // arrange
        FileHandler file = new FileHandler(".");

        // Act + Assert
        assertThrows(
                FileHandlerException.class,
                () -> file.save(new RegistrationRecord("3001234757", "CSIS3380", "2026Winter"))
        );
    }

    @Test
    void loadRecords_returns_objects() throws IOException {
        Path tempFile = Files.createTempFile("registrations-", ".txt");
        tempFile.toFile().deleteOnExit();

        FileHandler file = new FileHandler(tempFile.toString());

        file.save(new RegistrationRecord("3001234757", "CSIS3380", "2026Winter"));
        // file.save(new domain.RegistrationRecord("---", "course---", "2025---"));

        List<RegistrationRecord> records = file.loadRecords();

        assertEquals(1, records.size());
        assertEquals("3001234567", records.get(0).getStudentId());
        assertEquals("3001234757,CSIS3380,2026Winter", records.get(0).toString());
    }
}
