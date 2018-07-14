package dao;

import javax.enterprise.context.RequestScoped;
import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestScoped
public class RecipeBean {

    private final DataBaseForNow dataBaseForNow = new DataBaseForNow();

    public Recipe getRecipeForWeb(String nameRecipe){

        Optional<Recipe> recipe = dataBaseForNow.getRecipeList().stream().filter(r -> r.getName().equals(nameRecipe)).findFirst();

        return recipe.isPresent() ? recipe.get() : null;
    }

    public List<Recipe> getTimeCategory(Category category) {
        List<Recipe> timeCategory = dataBaseForNow.getRecipeList().stream().filter(r -> r.getCategory()==(category)).collect(Collectors.toList());
        return timeCategory;
    }

    public List<Recipe> getFavouriteList() {
        List<Recipe> favouriteList = dataBaseForNow.getRecipeList().stream().limit(3).collect(Collectors.toList());
        return favouriteList;
    }
}
