package servlets.mailServlets;

import com.sendgrid.*;
import dao.MailBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlets.recipeOperationsServlets.SearchRecipesServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mail-to-us")
public class MailToUsServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(MailToUsServlet.class);

    @Inject
    private MailBean mailBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("Started doPost method");
        StringBuilder sb = new StringBuilder();
        sb.append("New Message!!! \n\r");
        sb.append(req.getParameter("message") + "\n\r");
        sb.append("From: \n\r");
        sb.append(req.getParameter("name") + "\n\r");
        sb.append(req.getParameter("e-mail") + "\n\r");
        sb.append(req.getParameter("phone") + "\n\r");

        String mailText = sb.toString();

        Email from = new Email("YummyTime@App.com");
        String subject = "From users";
        logger.info("Send mail");
        Email to = new Email("yummytimeapp@gmail.com");
        Content content = new Content("text/plain", mailText);
        Mail mail = new Mail(from, subject, to, content);

        mailBean.sendEmail(mail);

        logger.debug("Redirecting to /contact");
        resp.sendRedirect("/contact");
    }
}
