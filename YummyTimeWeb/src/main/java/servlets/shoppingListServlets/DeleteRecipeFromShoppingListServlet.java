package servlets.shoppingListServlets;

import dao.ShoppingListOfUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sub-shoppingList")
public class DeleteRecipeFromShoppingListServlet extends HttpServlet {

    @Inject
    private ShoppingListOfUserDao shoppingListOfUserDao;

    private static Logger logger = LoggerFactory.getLogger(DeleteRecipeFromShoppingListServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Reading 'id' parameter.");
        String recipeIdParam = req.getParameter("id");

        if (recipeIdParam == null || recipeIdParam.isEmpty()) {
            logger.info("'id' parameter is invalid.");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Long recipeId = Long.valueOf(recipeIdParam);

        logger.info("Deleting recipe with id " + recipeId + " from Shopping List");
        shoppingListOfUserDao.deleteRecipeFromShoppingList(recipeId);

        logger.info("Redirecting to /shopping-list");
        resp.sendRedirect("/shopping-list");
    }
}
