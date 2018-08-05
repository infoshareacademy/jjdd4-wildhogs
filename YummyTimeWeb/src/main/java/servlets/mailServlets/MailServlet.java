package servlets.mailServlets;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sendgrid.*;
import dao.MailBean;
import dao.UserSessionBean;
import dao.ShoppingListOfUserDao;
import dao.UsersDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(MailServlet.class);

    @Inject
    private ShoppingListOfUserDao shoppingListOfUserDao;

    @Inject
    private MailBean mailBean;

    @Inject
    private UsersDao usersDao;

    @Inject
    private UserSessionBean userSessionBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("Started doPost method");
        StringBuilder sb = new StringBuilder();
        sb.append("Your shopping list : \n\r");
        sb.append("\n\r");

        shoppingListOfUserDao.getIngredientsInShoppingListOfUser().stream()
                .forEach(ingredient -> sb.append(ingredient.toString() + "\n\r"));
        sb.append("\n\r");
        sb.append("Cheers!");
        String mailText = sb.toString();

        Email from = new Email("YummyTime@App.com");
        String subject = "Shopping List";
        logger.info("Send mail");
        Email to = new Email(usersDao.findById(userSessionBean.getUserId()).getEmail());
        Content content = new Content("text/plain", mailText);
        Mail mail = new Mail(from, subject, to, content);
        mailBean.sendEmail(mail);

        logger.debug("Starting redirect to /shopping-list?send=yes");
        resp.sendRedirect("/shopping-list?send=yes");
    }
}
