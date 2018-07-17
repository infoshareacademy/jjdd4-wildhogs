package dao;

import javax.servlet.http.Part;
import java.io.*;
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

        return settings.getProperty("Upload.Path.Images");
    }


    public File uploadImageFile(Part filePart) throws  IOException {

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName== null || fileName.isEmpty()){
            throw new IOException("  no image uploaded ");
        }


        File file = new File(getUploadImageFilesPath()+fileName);

        InputStream fileContent = filePart.getInputStream();

        OutputStream os = new FileOutputStream(file);


        byte[] buffer = new byte[1024];
        int bytesRead;

        while((bytesRead=fileContent.read(buffer))!=-1){
            os.write(buffer,0, bytesRead);
        }
        fileContent.close();
        os.flush();
        os.close();

        return file;


    }

}
