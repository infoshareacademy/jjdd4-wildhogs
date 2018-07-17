package servlet;


import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import dao.IngredientDao;
import dao.LoadJSONBean;
import dao.RecipeDao;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/upload")
public class FindAllServlet extends HttpServlet {

    @Inject
    private RecipeDao recipeDao;

    @Inject
    private IngredientDao ingredientDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        final String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("findAll")) {
            findAll(req, resp);
        } else if (action.equals("upload")) {
            uploadDatabase(req, resp);
        } else if (action.equals("delete")) {
            deleteRecipe(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
    }

    private void uploadDatabase(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        LoadJSONBean loadJSON = new LoadJSONBean();
        Map<String, Recipe> recipes = loadJSON.getMapOfMeals();

        for (Recipe r : recipes.values()) {

            final Recipe recipe = new Recipe();
            recipe.setName(r.getName());
            recipe.setPathToPicture(r.getPathToPicture());
            recipe.setCategory(r.getCategory());
            recipe.setDescription(r.getDescription());
            recipe.setIngredientsList(r.getIngredientsList());
            recipeDao.save(recipe);
        }
        findAll(req, resp);
    }

    private void deleteRecipe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));

        recipeDao.delete(id);
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Recipe> result = recipeDao.findAll();
        for (Recipe p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }
}
