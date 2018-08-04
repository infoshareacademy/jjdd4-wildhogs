package servlets.loginLogoutServlets;

import dao.UserSessionBean;
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

@WebServlet("/logout-gmail")
public class LogoutViewServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(LogoutViewServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserSessionBean userSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "logout.ftlh");

        try {
            template.process(new Object(), resp.getWriter());

            userSessionBean.setLogged(false);
            userSessionBean.setEmail("");

        } catch (TemplateException e) {
            logger.warn("Can't load template", e);
        }
    }
}
