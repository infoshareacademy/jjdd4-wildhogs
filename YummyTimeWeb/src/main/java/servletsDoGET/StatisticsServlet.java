package servletsDoGET;

import dao.*;
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
import java.util.List;
import java.util.Map;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ViewRecipeServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeDao recipeDao;

    @Inject
    SessionBean sessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "statisticsWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        List<Statistic> categoryStatistic = recipeDao.categoryStatistics();
        List<Statistic> recipeStatistic = recipeDao.statisticRecipe();

        if (!categoryStatistic.isEmpty()) {
            model.put("categoryStatistic", categoryStatistic);
        }

        if (!recipeStatistic.isEmpty()) {
            model.put("recipeStatistic", recipeStatistic);
        }

        if(sessionBean.getLogged()){
            model.put("logged", "yes");
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.warn("View statistics cannot be loaded template!");
        }
    }
}
