package servlets.loginLogoutServlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshareacademy.jjdd4.wildhogs.data.User;
import dao.SessionBean;
import dao.UsersDao;
import googleApi.IdTokenVerifierAndParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlets.dataUploadServlets.UploadViewServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Inject
    private UsersDao usersDao;

    @Inject
    private SessionBean sessionBean;

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

            sessionBean.setEmail(email);
            sessionBean.setLogged(true);
            sessionBean.setUsername(name);

            List<String> emails = usersDao.findAll().stream().map(User::getEmail).collect(Collectors.toList());

            if (!emails.contains(email)) {
                logger.info("saving user to the database");
                usersDao.save(new User(name, email));
            }
            resp.sendRedirect("/welcome");

        } catch (Exception e) {
            logger.warn("Problems with sending user credentials to the database", e);
        }
    }
}