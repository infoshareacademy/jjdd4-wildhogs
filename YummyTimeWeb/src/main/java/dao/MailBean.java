package dao;

import com.sendgrid.*;
import org.slf4j.LoggerFactory;
import servlet.SearchRecipesServlet;
import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class MailBean {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(SearchRecipesServlet.class);

    public void sendEmail(Mail mail) {

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
            logger.info("Send mail failed", ex);
        }
    }
}
