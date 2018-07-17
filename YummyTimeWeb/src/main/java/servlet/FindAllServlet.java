package servlet;


import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;
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
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


@WebServlet("/test")
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
        }else if(action.equals("delete")){
            deleteRecipe(req, resp);
        }else {
            resp.getWriter().write("Unknown action.");
        }
    }


    private void uploadDatabase(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        PrintWriter writer = resp.getWriter();
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
        // Return all persisted objects
        findAll(req, resp);
    }

    private void deleteRecipe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        // LOG.info("Removing Recipe with id = {}", id);

        recipeDao.delete(id);

        // Return all persisted objects
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Recipe> result = recipeDao.findAll();
        //LOG.info("Found {} objects", result.size());
        for (Recipe p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }
}
