package servlet;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import dao.RecipeBean;
import dao.TemplateProvider;
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
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeBean recipeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "startWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        List<Recipe> timeCategory = recipeBean.getTimeCategory(Category.LUNCH);
        if(timeCategory != null && !timeCategory.isEmpty()) {
            model.put("timeCategory", timeCategory);
        }else {
            String errorMessage = "There is nothing in this category for now";
            model.put("errorMessage1", errorMessage);
        }
        List<Recipe> favouriteList = recipeBean.getFavouriteList();
        if(favouriteList != null && !favouriteList.isEmpty()) {
            model.put("favouriteList", favouriteList);
        }else {
            String errorMessage = "There is nothing in fovourite";
            model.put("errorMessage2", errorMessage);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
