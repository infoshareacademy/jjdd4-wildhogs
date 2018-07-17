package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestScoped
public class RecipesRepositoryDaoBean {

    @Inject
    private DataBaseForNow dataBaseForNow;

    public Recipe getRecipe(String nameRecipe){
        Optional<Recipe> recipe = dataBaseForNow.getRecipesList().stream()
                .filter(r -> r.getName().equals(nameRecipe)).findFirst();
        return recipe.isPresent() ? recipe.get() : null;
    }

    public List<BlockRecipe> getFavouriteList() {
        List<BlockRecipe> recipes = dataBaseForNow.getRecipesList().stream()
                .map(r -> new BlockRecipe(r.getName(), r.getPathToPicture())).limit(3)
                .collect(Collectors.toList());
        return recipes;
    }

    public List<BlockRecipe> getRecipesFromCategory(Category category, long limit) {
        List<BlockRecipe> recipes = dataBaseForNow.getRecipesList().stream()
                .filter(r -> r.getCategory()==(category)).map(r -> new BlockRecipe(r.getName(),
                        r.getPathToPicture())).limit(limit).collect(Collectors.toList());
        return recipes;
    }

    public List<BlockRecipe> getRecipesFromCategory(Category category) {
        return getRecipesFromCategory(category, Long.MAX_VALUE);
    }

    public List<BlockRecipe> getRecipesForProducts(List<String> products) {
        List<BlockRecipe> recipes = dataBaseForNow.getRecipesList().stream()
                .map(r -> new BlockRecipe(r.getName(), r.getPathToPicture()))
                .limit(3).collect(Collectors.toList());
        return recipes;
    }

    public List<Ingredient> getShoppingList() {
        return dataBaseForNow.getIngredientsList();
    }

    public boolean addRecipeToFavorites(String name) {
        // add to favorite
        return true;
    }

    public boolean addRecipeToShoppingList(String name) {
        // add to shopping list
        return true;
    }
}
