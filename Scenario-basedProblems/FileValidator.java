import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

public class FileValidator {

    public void validateCsvFile(String filePath) throws InvalidFileFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();
            if (headerLine == null || !headerLine.contains("ID") || !headerLine.contains("Name") || !headerLine.contains("Value")) {
                throw new InvalidFileFormatException("Required headers are missing from the file.");
            }
        }
    }
}
