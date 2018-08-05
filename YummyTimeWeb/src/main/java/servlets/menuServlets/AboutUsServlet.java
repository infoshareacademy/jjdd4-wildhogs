package servlets.menuServlets;

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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/about")
public class AboutUsServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(AboutUsServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserSessionBean userSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");


        Template template = templateProvider.getTemplate(getServletContext(), "aboutUs.ftlh");
        Map<String, Object> model = new HashMap<>();

        if(userSessionBean.getLogged()){
            model.put("logged", "yes");
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.warn("Can't load template",e);
        }
    }
}
