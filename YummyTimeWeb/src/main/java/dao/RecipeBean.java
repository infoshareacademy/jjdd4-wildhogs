package dao;

import javax.enterprise.context.RequestScoped;
import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;

@RequestScoped
public class RecipeBean {

    private Recipe recipe;

    public Recipe getRecipeForWeb(String nameRecipe){

        recipe = new Recipe("Grilled Mexican Street Corn", Category.LUNCH, "Remove the husks of the corn " +
                "leaving the core attached. Grill the corn turning once on a hot grill or cast iron pan until it starts to get slightly charred...");

        recipe.addIngredient("mayonnaise", new Ingredient("mayonnaise", 0.5, Unit.CUP));
        recipe.addIngredient("sour cream", new Ingredient("sour cream", 0.5, Unit.CUP));
        recipe.addIngredient("chopped cilantro", new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        recipe.addIngredient("parmesan", new Ingredient("parmesan", 1, Unit.CUP));
        recipe.addIngredient("lime", new Ingredient("lime", 1, Unit.UNIT));
        recipe.addIngredient("red chile powder", new Ingredient("red chile powder", 1, Unit.UNIT));

        recipe.setPathToPicture("https://www.simplyrecipes.com/wp-content/uploads/2016/07/2016-07-29-Street-Corn-14.jpg");

        return recipe;
    }
}
