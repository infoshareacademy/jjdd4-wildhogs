package servlet;

import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import dao.IngredientDao;
import dao.RecipeChangeDao;
import dao.RecipeDao;
import dao.TemplateProvider;
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

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ViewRecipeServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeDao recipeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "statisticsWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        recipeDao.categoryStatistic();

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
