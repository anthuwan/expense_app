

package expense.calculator.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileUtility {

    public static String getFileContent(String fileName) throws IOException {
        try (final BufferedReader inputData =
            new BufferedReader(
                new InputStreamReader(
                    FileUtility.class.getResourceAsStream("/mock-response/" + fileName)))) {
            return inputData.lines().collect(Collectors.joining("\n"));
        }
    }

}
