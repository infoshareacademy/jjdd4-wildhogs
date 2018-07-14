package servlet;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import dao.RecipeBean;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/servlet.view-recipe")
public class ViewRecipeServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeBean recipeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeNameParam = req.getParameter("name");

        if (recipeNameParam == null || recipeNameParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Template template = templateProvider.getTemplate(getServletContext(), "view-recipe.ftlh");
        Map<String, Object> model = new HashMap<>();

        PrintWriter writer = resp.getWriter();

        Recipe recipe = recipeBean.getRecipeForWeb("Grilled Mexican Street Corn");

        model.put("recipe", recipe);



        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
