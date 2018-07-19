package servlet;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import dao.BlockRecipe;
import dao.RecipesRepositoryDaoBean;
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
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(WelcomeServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipesRepositoryDaoBean recipesRepositoryDaoBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "startWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        LocalTime time = LocalTime.now();
        int hour = time.getHour();

        Category categoryByTime = categoryByHour(hour);
        model.put("defaultCategory", categoryByTime.toString());
        List<BlockRecipe> recipesForDefaultCategory = recipesRepositoryDaoBean.getRecipesFromCategory(categoryByTime, 3);
        if(recipesForDefaultCategory != null && !recipesForDefaultCategory.isEmpty()) {
            model.put("recipesForDefaultCategory", recipesForDefaultCategory);
        }

        List<BlockRecipe> favouriteList = recipesRepositoryDaoBean.getFavouriteList();
        if(favouriteList != null && !favouriteList.isEmpty()) {
            model.put("favouriteList", favouriteList);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.warn("View recipe cannot be loaded template!");
        }
    }

    private Category categoryByHour(int hour) {
        if(hour > 2 && hour < 10) {
            return Category.BREAKFAST;
        } else if(hour >= 10 && hour < 14) {
            return Category.LUNCH;
        } else if(hour >= 14 && hour < 17) {
            return Category.DINNER;
        }
        return Category.SUPPER;
    }
}
