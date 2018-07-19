package servlet;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/shopping-list")
public class ShoppingListServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ShoppingListServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipesRepositoryDaoBean recipesRepositoryDaoBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "shoppingListWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        List<Ingredient> shoppingList = recipesRepositoryDaoBean.getShoppingList();
        List<BlockRecipe> recipesInShoppingList = recipesRepositoryDaoBean.getRecipeInShoppingList();

        if(shoppingList != null || !shoppingList.isEmpty()) {
            model.put("shoppingList", shoppingList);
            model.put("recipesInShoppingList", recipesInShoppingList);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.warn("View shopping list cannot be loaded template!");
        }
    }
}