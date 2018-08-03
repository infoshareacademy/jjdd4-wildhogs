package servletsDoPOST;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshareacademy.jjdd4.wildhogs.data.User;
import dao.SessionBean;
import dao.UsersDao;
import googleApi.IdTokenVerifierAndParser;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Inject
    UsersDao usersDao;

    @Inject
    SessionBean sessionBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            sessionBean.setEmail(email);
            sessionBean.setLogged(true);
            sessionBean.setUsername(name);

            List<String> emails  = usersDao.findAll().stream().map(User::getEmail).collect(Collectors.toList());

            if (!emails.contains(email)) {
                usersDao.save(new User(name, email));
            }
            resp.sendRedirect("/welcome");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}