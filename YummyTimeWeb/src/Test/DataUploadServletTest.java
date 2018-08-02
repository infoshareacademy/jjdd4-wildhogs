package servlet;

import ch.qos.logback.classic.Logger;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class DataUploadServletTest {

    @Test
    public void deleteFileIfExists() {
        Logger logger = null;
        File file = null;
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doPost() {
    }

    @Test
    public void doGet() {
    }
}

