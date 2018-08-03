package servlet;


import dao.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/upload")
public class UploadViewServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(LoginViewServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "upload.ftlh");

        try {
            template.process(new Object(), resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.warn("Can't load template");
        }
    }
}