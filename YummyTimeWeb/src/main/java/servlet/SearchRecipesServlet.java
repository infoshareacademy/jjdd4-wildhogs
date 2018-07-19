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
import java.util.*;

@WebServlet("/search-recipe")
public class SearchRecipesServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SearchRecipesServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipesRepositoryDaoBean recipesRepositoryDaoBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String categoryParam = req.getParameter("category");
        String fridgeParam = req.getParameter("fridge");

        if ( (parameterIsNotEmpty(categoryParam) && parameterIsNotEmpty(fridgeParam))
                || (!parameterIsNotEmpty(categoryParam) && fridgeParam == null) ) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "searchWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        if(parameterIsNotEmpty(categoryParam)) {
            try{
                List<BlockRecipe> recipesList = recipesRepositoryDaoBean.getRecipesFromCategory(Category.valueOf(categoryParam.toUpperCase()));
                model.put("recipesList", recipesList);
                model.put("parameter", categoryParam);
                if(recipesList.isEmpty()) {
                    String errorMessage = "There is nothing in category " + categoryParam;
                    model.put("errorMessage", errorMessage);
                }
            }catch (IllegalArgumentException e) {
                String errorMessage = "There is no category " + categoryParam;
                model.put("errorMessage", errorMessage);
            }
        }

        if(fridgeParam != null) {
            String fridge = fridgeParam.replace("%2C", ",")
                    .replace("+", ",").replace(",*", ",");
            List<String> fridgeList = Arrays.asList(fridge.split(","));
            List<BlockRecipe> recipesList = recipesRepositoryDaoBean.getRecipesForProducts(fridgeList);
            model.put("recipesList", recipesList);
            model.put("parameter", fridgeParam);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.warn("View search recipe cannot be loaded template!");
        }
    }

    private boolean parameterIsNotEmpty(String parameter) {
        if (parameter != null && !parameter.isEmpty()) {
            return true;
        }
        return false;
    }
}
