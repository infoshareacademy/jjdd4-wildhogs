package servlets.recipeOperationsServlets;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import dao.BlockRecipe;
import dao.RecipeDao;
import dao.UserSessionBean;
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
import java.util.stream.Collectors;

@WebServlet("/search-recipe")
public class SearchRecipesServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SearchRecipesServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeDao recipeDao;

    @Inject
    private UserSessionBean userSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String categoryParam = req.getParameter("category");
        String fridgeParam = req.getParameter("fridge");

        if ((parameterIsNotEmpty(categoryParam) && parameterIsNotEmpty(fridgeParam))
                || (!parameterIsNotEmpty(categoryParam) && fridgeParam == null)) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "searchWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        if (parameterIsNotEmpty(categoryParam)) {
            try {
                List<BlockRecipe> recipesList = recipeDao.getRecipesFromCategory(Category.valueOf(categoryParam.toUpperCase()));
                model.put("recipesList", recipesList);
                model.put("parameter", categoryParam);
                if (recipesList.isEmpty()) {
                    String errorMessage = "There is nothing in category " + categoryParam;
                    model.put("errorMessage", errorMessage);
                }
            } catch (IllegalArgumentException e) {
                String errorMessage = "There is no category " + categoryParam;
                model.put("errorMessage", errorMessage);
            }
        }

        if (fridgeParam != null) {
            String fridge = fridgeParam.replace(" ", ",");
            List<String> fridgeList = Arrays.asList(fridge.split(","));
            fridgeList = fridgeList.stream().filter(f -> !f.equals("")).filter(f -> f.length() > 2).collect(Collectors.toList());

            if (!fridgeList.isEmpty()) {
                List<BlockRecipe> recipesList = recipeDao.getRecipesForProducts(fridgeList);

                if (!recipesList.isEmpty()) {
                    model.put("recipesList", recipesList);
                    model.put("parameter", fridgeParam);
                } else {
                    putErrorMessageFridge(fridgeParam, model);
                }
            } else {
                putErrorMessageFridge(fridgeParam, model);
            }

        }

        if (userSessionBean.getLogged()) {
            model.put("logged", "yes");
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.warn("Can't load template", e);
        }
    }

    private void putErrorMessageFridge(String fridgeParam, Map<String, Object> model) {
        String errorMessage = "There is nothing for these ingredients: " + fridgeParam;
        model.put("errorMessage", errorMessage);
        model.put("tryAgain", "");
    }

    private boolean parameterIsNotEmpty(String parameter) {
        if (parameter != null && !parameter.isEmpty()) {
            return true;
        }
        return false;
    }
}
