package servlet;

import dao.RecipeChangeDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-favorite")
public class RecipeToFavoriteServlet extends HttpServlet{

    @Inject
    private RecipeChangeDao recipeChangeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeNameParam = req.getParameter("name");

        if (recipeNameParam == null || recipeNameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Boolean recipeAdd = recipeChangeDao.addRecipeToFavorites(recipeNameParam);

        String path;
        if(recipeAdd) {
            path = "/view-recipe?name=" + recipeNameParam + "&favorite=yes";
        } else {
            path = "/view-recipe?name=" + recipeNameParam;
        }
        resp.sendRedirect(path);
    }
}
