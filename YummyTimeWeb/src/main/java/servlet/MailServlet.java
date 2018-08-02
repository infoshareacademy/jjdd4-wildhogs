package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.sendgrid.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SearchRecipesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter writer = resp.getWriter();
        writer.println("test2");

        Email from = new Email("test@example.com");
        String subject = "Sending with SendGrid is Fun";
        logger.info("from");
        Email to = new Email("matmazur90@gmail.com");
        logger.info("from");
        Content content = new Content("text/plain", "<3 ;) your shopping list");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
