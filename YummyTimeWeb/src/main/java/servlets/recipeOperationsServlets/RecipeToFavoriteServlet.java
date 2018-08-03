package servlets.recipeOperationsServlets;

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

@WebServlet("/to-favorite")
public class RecipeToFavoriteServlet extends HttpServlet {

    @Inject
    private RecipeChangeDao recipeChangeDao;

    private static Logger logger = LoggerFactory.getLogger(RecipeToFavoriteServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeIdParam = req.getParameter("id");
        logger.info("Reading 'id' parameter.");

        if (recipeIdParam == null || recipeIdParam.isEmpty()) {
            logger.info("'id' parameter is invalid.");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Long recipeId =  Long.valueOf(recipeIdParam);

        Boolean recipeAdd = recipeChangeDao.addRecipeToFavorites(recipeId);

        String path;
        if(recipeAdd) {
            path = "/view-recipe?id=" + recipeIdParam + "&favorite=yes";
            logger.info("Recipe added to favorites.");
        } else {
            path = "/view-recipe?id=" + recipeIdParam;
        }
        resp.sendRedirect(path);
    }
}
