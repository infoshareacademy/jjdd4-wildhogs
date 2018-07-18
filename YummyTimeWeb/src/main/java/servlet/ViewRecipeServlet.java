package servlet;

import dao.RecipesRepositoryDaoBean;
import dao.TemplateProvider;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipesRepositoryDaoBean recipesRepositoryDaoBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeNameParam = req.getParameter("name");

        if (recipeNameParam == null || recipeNameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "viewRecipeWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        Recipe recipe = recipesRepositoryDaoBean.getRecipe(recipeNameParam);

        if(recipe != null) {
            model.put("recipe", recipe);
        }

        try {
            String favorite = req.getParameter("favorite");
            if(favorite.equals("yes")) {
                model.put("message", "Your recipe has been added to favorite!");
            }
        }catch (Exception e){}

        try {
            String favorite = req.getParameter("shoppingList");
            if(favorite.equals("yes")) {
                model.put("message", "Your recipe has been added to shopping list!");
            }
        }catch (Exception e){}

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
