package servlet;

import dao.RecipeChangeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-shoppingList")
public class RecipeToShoppingList extends HttpServlet{

    @Inject
    private RecipeChangeDao recipeChangeDao;

    private static Logger logger = LoggerFactory.getLogger(RecipeToFavoriteServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Reading 'name' parameter");
        String recipeNameParam = req.getParameter("name");

        if (recipeNameParam == null || recipeNameParam.isEmpty()) {
            logger.info("'name' parameter is invalid");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Boolean recipeAdd = recipeChangeDao.addRecipeToShoppingList(recipeNameParam);

        String path;
        if(recipeAdd) {
            logger.info("Recipe added to shopping list");
            path = "/view-recipe?name=" + recipeNameParam + "&shoppingList=yes";
        } else {
            path = "/view-recipe?name=" + recipeNameParam;
        }
        resp.sendRedirect(path);
    }
}
