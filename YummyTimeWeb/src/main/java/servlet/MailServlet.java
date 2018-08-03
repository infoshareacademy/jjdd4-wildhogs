package servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.sendgrid.*;
import dao.MailBean;
import dao.ShoppingListOfUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SearchRecipesServlet.class);

    @Inject
    ShoppingListOfUserDao shoppingListOfUserDao;

    @Inject
    private MailBean mailBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Boolean logged = (Boolean) session.getAttribute("logged");
        String email = (String) session.getAttribute("email");

        StringBuilder sb = new StringBuilder();
        sb.append("Your shopping list : \n\r\r\n");

        shoppingListOfUserDao.getIngridientsInShoppingListOfUser().stream()
                .forEach(ingredient -> sb.append(ingredient.toString() + "\n\r"));
        sb.append("\n\r\n\r Cheers!");
        String mailText = sb.toString();

        Email from = new Email("YummyTime@App.com");
        String subject = "Shopping List";
        logger.info("Send mail");
        Email to = new Email(email);
        Content content = new Content("text/plain", mailText);
        Mail mail = new Mail(from, subject, to, content);
        mailBean.sendEmail(mail);

        resp.sendRedirect("/shopping-list?send=yes");
    }
}
