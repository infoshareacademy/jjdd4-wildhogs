package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class ShoppingListOfUserDao {

    @Inject
    private RecipeDao recipeDao;
    private List<Long> recipesIsInShoppingList;

    public ShoppingListOfUserDao() {
        if(recipesIsInShoppingList == null){
            recipesIsInShoppingList = new ArrayList<>();
        }
    }

    public List<Ingredient> getIngridientsInShoppingListOfUser() {
        ShoppingList shoppingListIngredients = new ShoppingList(getListOfRecipe());
        return shoppingListIngredients.getShoppingList();
    }

    public List<BlockRecipe> getRecipeInShoppingList() {
        return recipeDao.changeRecipiesToBlocks(getListOfRecipe());
    }

    public boolean addRecipeToShoppingList(Long recipeId) {
        if(recipeDao.findById(recipeId) != null) {
            recipesIsInShoppingList.add(recipeId);
            return true;
        }
        return false;
    }

    private List<Recipe> getListOfRecipe() {
        return recipesIsInShoppingList.stream()
                .map(recipeId -> recipeDao.findById(recipeId))
                .collect(Collectors.toList());
    }
}
