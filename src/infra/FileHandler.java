package infra;

import domain.RegistrationRecord;

import java.io.*;
import java.util.*;

public class FileHandler {

    private final String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public FileHandler() {
        this("registrations.txt");
    }

    public void save(RegistrationRecord record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(record.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new FileHandlerException(
                    "Failed to write registrations file.",
                    e
            );
        }
    }

    public List<RegistrationRecord> loadRecords() {
        List<RegistrationRecord> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] parts = line.split(",");

                if (parts.length != 3) {
                    throw new FileHandlerException(
                            "Invalid registration line format: " + line
                    );
                }

                String studentId = parts[0].trim();
                String courseId = parts[1].trim();
                String term = parts[2].trim();

                records.add(new RegistrationRecord(studentId, courseId, term));
            }
        } catch (IOException e) {
            throw new FileHandlerException("Failed to read registrations file.", e);
        }

        return records;
    }
}
