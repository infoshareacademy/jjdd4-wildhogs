package servlet;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import dao.IngredientDao;
import dao.RecipeChangeDao;
import dao.RecipeDao;
import dao.TemplateProvider;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.HEAD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/view-recipe")
public class ViewRecipeServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ViewRecipeServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeDao recipeDao;

    @Inject
    private RecipeChangeDao recipeChangeDao;

    @Inject
    private IngredientDao ingredientDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeIdParam = req.getParameter("id");

        if (recipeIdParam == null || recipeIdParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Long recipeId = Long.valueOf(recipeIdParam);

        Template template = templateProvider.getTemplate(getServletContext(), "viewRecipeWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        Recipe recipe = recipeDao.findById(recipeId);

        if (recipe != null) {
            model.put("recipe", recipe);
            recipeChangeDao.incrementStatisticsPerView(recipe.getId());
            recipe.setTimesClicked(recipe.getTimesClicked() + 1);
        }

        String favorite = req.getParameter("favorite");
        if ("yes".equals(favorite)) {
            model.put("message", "Your recipe has been added to favorite!");
        }

        String shoppingList = req.getParameter("shoppingList");
        if ("yes".equals(shoppingList)) {
            model.put("message", "Your recipe has been added to shopping list!");
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.warn("View recipe cannot be loaded template!");
        }
    }
}
