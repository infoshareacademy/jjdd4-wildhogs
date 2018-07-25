package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/clear-list")
public class ClearShoppingListServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(ClearShoppingListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("real-shopping-list") != null) {
            session.setAttribute("real-shopping-list", new ArrayList<>());
        }
        if (session.getAttribute("recipe-list") != null) {
            session.setAttribute("recipe-list", new ArrayList<>());
        }

        logger.info("Lists containing shopping list and names of recipes are now new empty ones.");
        resp.sendRedirect("/shopping-list");
    }
}