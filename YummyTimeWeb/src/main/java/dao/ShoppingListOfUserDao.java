package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.data.ShoppingListItem;
import com.infoshareacademy.jjdd4.wildhogs.data.User;
import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class ShoppingListOfUserDao {

    @Inject
    private RecipeDao recipeDao;

    @Inject
    private UsersDao usersDao;

    @Inject
    private UserSessionBean userSessionBean;

    public ShoppingListOfUserDao() {
    }

    public List<Ingredient> getIngredientsInShoppingListOfUser() {
        ShoppingList shoppingListIngredients = new ShoppingList(getListOfRecipe());
        return shoppingListIngredients.getShoppingList();
    }

    public List<BlockRecipe> getRecipeInShoppingList() {
        return recipeDao.changeRecipiesToBlocks(getListOfRecipe());
    }

    public boolean addRecipeToShoppingList(Long recipeId) {
        Recipe recipe = recipeDao.findById(recipeId);
        if (recipe != null) {
            User user = getUser();
            if (user != null) {
                user.getShoppingList().add(new ShoppingListItem(recipe, user));
                usersDao.update(user);
                return true;
            }
        }
        return false;
    }

    public void deleteRecipeFromShoppingList(Long recipeId){
        User user = getUser();
        if (user != null) {
            List<ShoppingListItem> shoppingListItems = user.getShoppingList();
            Optional<ShoppingListItem> shoppingListItemOptional = shoppingListItems.stream()
                    .filter(item -> item.getRecipe().getId() == recipeId).findAny();

            if (shoppingListItemOptional.isPresent()) {
                shoppingListItems.remove(shoppingListItemOptional.get());
                usersDao.update(user);
            }
        }
    }

    private User getUser() {
        return usersDao.findById(userSessionBean.getUserId());
    }

    private List<Recipe> getListOfRecipe() {
        return getUser().getShoppingList().stream()
                .map(shoppingListItem -> shoppingListItem.getRecipe())
                .collect(Collectors.toList());
    }
}
