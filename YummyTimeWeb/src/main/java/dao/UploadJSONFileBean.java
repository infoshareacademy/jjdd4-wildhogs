package dao;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class UploadJSONFileBean {

    private final static String SETTINGS_FILE = "config.properties";
    public String getUploadFilesPath() throws  IOException {


        Properties settings = new Properties();

        settings.load(Thread.currentThread()
                .getContextClassLoader()
                .getResource(SETTINGS_FILE)
                .openStream());

        return settings.getProperty("Upload.Path");
    }


    public File uploadImageFile(Part filePart) throws  IOException {

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName== null || fileName.isEmpty()){
            throw new IOException("  no file uploaded ");
        }


        File file = new File(getUploadFilesPath()+fileName);

        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();
        Files.copy(fileContent, file.toPath());

        fileContent.close();


        return file;


    }



}
