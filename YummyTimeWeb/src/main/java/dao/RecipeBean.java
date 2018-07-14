package dao;

import javax.enterprise.context.RequestScoped;
import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class RecipeBean {

    private Recipe recipe1;

    public Recipe getRecipeForWeb(String nameRecipe){

        recipe1 = new Recipe("Grilled Mexican Street Corn", Category.LUNCH, "Remove the husks of the corn leaving " +
                "the core attached. Grill the corn turning once on a hot grill or cast iron pan until it starts to get slightly charred. " +
                "In a small bowl mix the mayonnaise, sour cream and cilantro. Remove the corn from the grill and slather with " +
                "the mayonnaise mix. Squeeze the lime juice over the corn and heavily season with parmesan. Sprinkle with chili powder.");

        recipe1.addIngredient("mayonnaise", new Ingredient("mayonnaise", 0.5, Unit.CUP));
        recipe1.addIngredient("sour cream", new Ingredient("sour cream", 0.5, Unit.CUP));
        recipe1.addIngredient("chopped cilantro", new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        recipe1.addIngredient("parmesan", new Ingredient("parmesan", 1, Unit.CUP));
        recipe1.addIngredient("lime", new Ingredient("lime", 1, Unit.UNIT));
        recipe1.addIngredient("red chile powder", new Ingredient("red chile powder", 1, Unit.UNIT));

        recipe1.setPathToPicture("https://www.simplyrecipes.com/wp-content/uploads/2016/07/2016-07-29-Street-Corn-14.jpg");

        return recipe1;
    }
}
