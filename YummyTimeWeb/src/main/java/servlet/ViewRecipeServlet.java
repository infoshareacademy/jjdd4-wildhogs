package servlet;

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
import java.io.IOException;
import java.util.HashMap;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeNameParam = req.getParameter("name");

        if (recipeNameParam == null || recipeNameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "viewRecipeWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        Recipe recipe = recipeDao.getRecipeByName(recipeNameParam);

        if(recipe != null) {
            model.put("recipe", recipe);
            recipeChangeDao.addRecipeToStatistic(recipe.getName());
        }

        String favorite = req.getParameter("favorite");
        if("yes".equals(favorite)){
            model.put("message", "Your recipe has been added to favorite!");
        }

        String shoppingList = req.getParameter("shoppingList");
        if("yes".equals(shoppingList)) {
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
