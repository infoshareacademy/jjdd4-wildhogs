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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/view-recipe")
public class ViewRecipeServlet extends HttpServlet {


    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeDao recipeDao;

    @Inject
    private RecipeChangeDao recipeChangeDao;

    @Inject
    private IngredientDao ingredientDao;

    private static Logger logger = LoggerFactory.getLogger(ViewRecipeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

        if (session.getAttribute("real-shopping-list") == null) {
            logger.info("Created new shopping list");

            session.setAttribute("real-shopping-list", new ArrayList<>());
        }
        List<Ingredient> list = (List<Ingredient>) session.getAttribute("real-shopping-list");


        String recipeNameParam = req.getParameter("name");

        if (recipeNameParam == null || recipeNameParam.isEmpty()) {
            logger.warn("Parameter 'name' was invalid.");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        logger.info("Reading template viewRecipeWeb.ftlh");
        Template template = templateProvider.getTemplate(getServletContext(), "viewRecipeWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        Recipe recipe = recipeDao.getRecipeByName(recipeNameParam);

        if (recipe != null) {
            logger.info("Putting recipe to statistics");

            model.put("recipe", recipe);
            recipeChangeDao.addRecipeToStatistic(recipe.getName());
        }

        String favorite = req.getParameter("favorite");
        if ("yes".equals(favorite)) {
            logger.info("Putting recipe to favorites");

            model.put("message", "Your recipe has been added to favorite!");
        }

        String shoppingList = req.getParameter("shoppingList");
        if ("yes".equals(shoppingList)) {
            logger.info("Putting ingredients to shopping list");


//sumuje ingredienty - dorobic pokazywanie recipe  i ile razy
            //*******************
            for (Ingredient i : recipe.getIngredientsList()) {

                if (list.contains(i)) {
                    for (int x = 0; x < list.size(); x++) {
                        if (list.get(x).equals(i)){
                            Long id=list.get(x).getId();
                            list.get(x).setAmount(list.get(x).getAmount() + ingredientDao.findById(id).getAmount());
                    }}
                } else
                    list.add(i);
            }
            model.put("message", "Your recipe has been added to shopping list!");
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.error("Template processing on map didn't work");
        }
    }
}
