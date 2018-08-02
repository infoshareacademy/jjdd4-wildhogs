package servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.sendgrid.*;
import dao.ShoppingListOfUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SearchRecipesServlet.class);

    @Inject
    ShoppingListOfUserDao shoppingListOfUserDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("Your shopping list : \n\r");

        shoppingListOfUserDao.getIngridientsInShoppingListOfUser().stream()
                .forEach(ingredient -> sb.append(ingredient.toString() + "\n\r"));
        sb.append("\n\r Cheers!");
        String mailText = sb.toString();

        Email from = new Email("YummyTime@App.com");
        String subject = "Shopping List";
        logger.info("Send mail");
        Email to = new Email("nwe.nat@gmail.com");
        Content content = new Content("text/plain", mailText);
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
            logger.info("Send mail falid");
            throw ex;
        }
    }
}
