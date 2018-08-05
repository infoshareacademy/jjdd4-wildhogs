package servlets.shoppingListServlets;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import dao.BlockRecipe;
import dao.UserSessionBean;
import dao.ShoppingListOfUserDao;
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
    private ShoppingListOfUserDao shoppingListOfUserDao;

    @Inject
    private UserSessionBean userSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "shoppingListWeb.ftlh");
        Map<String, Object> model = new HashMap<>();

        if(userSessionBean.getLogged()){
            List<BlockRecipe> recipesInShoppingList = shoppingListOfUserDao.getRecipeInShoppingList();
            List<Ingredient> shoppingList = shoppingListOfUserDao.getIngredientsInShoppingListOfUser();

            if (recipesInShoppingList != null && !recipesInShoppingList.isEmpty()) {
                logger.info("Recipes were saved to the shopping list.");
                model.put("recipesInShoppingList", recipesInShoppingList);
                model.put("shoppingList", shoppingList);
            }
            else {
                logger.warn("Problem with saving recipes to the shopping list");
            }
            String sendMail = req.getParameter("send");
            if ("yes".equals(sendMail)) {
                model.put("message", "Your Shopping List was sent");
            }
            model.put("logged", "yes");
        }
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.warn("Can't load template",e);
        }
    }
}