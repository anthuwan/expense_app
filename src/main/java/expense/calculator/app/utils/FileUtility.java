/*
 * InstaReM Overseas Money Transfer.
 * https://www.instarem.com/en-in/
 *
 * Copyright (c) 2014-2020 InstaReM
 *
 * This file is licensed and cannot be accessed outside InstaReM.
 * It can only be accessed and modified by the authorized InstaReM Technical Teams.
 * All unauthorized modifications to the content of this file,
 * will be prosecuted under the Copyright Act.
 */

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

    @Value("${file.key}")
    private String s3FilePath;

    @Value("${writeToS3}")
    private boolean writeToS3;


    public static String getFileContent(String fileName) throws IOException {
        try (final BufferedReader inputData =
            new BufferedReader(
                new InputStreamReader(
                    FileUtility.class.getResourceAsStream("/mock-response/" + fileName)))) {
            return inputData.lines().collect(Collectors.joining("\n"));
        }
    }

}
