package servlets.loginLogoutServlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshareacademy.jjdd4.wildhogs.data.User;
import dao.UserSessionBean;
import dao.UsersDao;
import googleApi.IdTokenVerifierAndParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Inject
    private UsersDao usersDao;

    @Inject
    private UserSessionBean userSessionBean;

    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            logger.info("Reading information from GoogleIdToken.Payload");
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            User user = usersDao.findByEmail(email);
            if (user == null) {
                logger.info("saving user to the database");
                user = new User(name, email);
                usersDao.save(user);
            }

            userSessionBean.setLogged(true);
            userSessionBean.setUserId(user.getId());

            resp.sendRedirect("/welcome");

        } catch (Exception e) {
            logger.warn("Problems with sending user credentials to the database", e);
        }
    }
}