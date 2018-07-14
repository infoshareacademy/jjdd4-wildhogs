package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DataBaseForNow {

    private final List<Recipe> recipesList = new ArrayList<>();
    private final List<Ingredient> ingredientsList = new ArrayList<>();

    public DataBaseForNow() {

        Recipe recipe1 = new Recipe("recipe1", Category.LUNCH, "Remove the husks of the corn leaving " +
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

        Recipe recipe2 = new Recipe("recipe2", Category.LUNCH, "Remove the husks of the corn leaving " +
                "the core attached. Grill the corn turning once on a hot grill or cast iron pan until it starts to get slightly charred. " +
                "In a small bowl mix the mayonnaise, sour cream and cilantro. Remove the corn from the grill and slather with " +
                "the mayonnaise mix. Squeeze the lime juice over the corn and heavily season with parmesan. Sprinkle with chili powder.");
        recipe2.addIngredient("mayonnaise", new Ingredient("mayonnaise", 0.5, Unit.CUP));
        recipe2.addIngredient("sour cream", new Ingredient("sour cream", 0.5, Unit.CUP));
        recipe2.addIngredient("chopped cilantro", new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        recipe2.addIngredient("parmesan", new Ingredient("parmesan", 1, Unit.CUP));
        recipe2.addIngredient("lime", new Ingredient("lime", 1, Unit.UNIT));
        recipe2.addIngredient("red chile powder", new Ingredient("red chile powder", 1, Unit.UNIT));
        recipe2.setPathToPicture("https://d-nm.ppstatic.pl/kadr/k/r/2b/55/5862637902303_o,size,933x0,q,70,h,d9d9f1.jpg");

        Recipe recipe3 = new Recipe("recipe3", Category.LUNCH, "Remove the husks of the corn leaving " +
                "the core attached. Grill the corn turning once on a hot grill or cast iron pan until it starts to get slightly charred. " +
                "In a small bowl mix the mayonnaise, sour cream and cilantro. Remove the corn from the grill and slather with " +
                "the mayonnaise mix. Squeeze the lime juice over the corn and heavily season with parmesan. Sprinkle with chili powder.");
        recipe3.addIngredient("mayonnaise", new Ingredient("mayonnaise", 0.5, Unit.CUP));
        recipe3.addIngredient("sour cream", new Ingredient("sour cream", 0.5, Unit.CUP));
        recipe3.addIngredient("chopped cilantro", new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        recipe3.addIngredient("parmesan", new Ingredient("parmesan", 1, Unit.CUP));
        recipe3.addIngredient("lime", new Ingredient("lime", 1, Unit.UNIT));
        recipe3.addIngredient("red chile powder", new Ingredient("red chile powder", 1, Unit.UNIT));
        recipe3.setPathToPicture("https://img1.esquire.pl/960x540/a/17/04/oto-co-jedza-mieszkancy-najzdrowszych-krajach-swiata_58fa2319.jpeg");

        Recipe recipe4 = new Recipe("recipe4", Category.BREAKFAST, "Remove the husks of the corn leaving " +
                "the core attached. Grill the corn turning once on a hot grill or cast iron pan until it starts to get slightly charred. " +
                "In a small bowl mix the mayonnaise, sour cream and cilantro. Remove the corn from the grill and slather with " +
                "the mayonnaise mix. Squeeze the lime juice over the corn and heavily season with parmesan. Sprinkle with chili powder.");
        recipe4.addIngredient("mayonnaise", new Ingredient("mayonnaise", 0.5, Unit.CUP));
        recipe4.addIngredient("sour cream", new Ingredient("sour cream", 0.5, Unit.CUP));
        recipe4.addIngredient("chopped cilantro", new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        recipe4.addIngredient("parmesan", new Ingredient("parmesan", 1, Unit.CUP));
        recipe4.addIngredient("lime", new Ingredient("lime", 1, Unit.UNIT));
        recipe4.addIngredient("red chile powder", new Ingredient("red chile powder", 1, Unit.UNIT));
        recipe4.setPathToPicture("https://szukajacprzygody.pl/wp-content/uploads/2017/09/IMG_6429.jpg");

        Recipe recipe5 = new Recipe("recipe5", Category.BREAKFAST, "Remove the husks of the corn leaving " +
                "the core attached. Grill the corn turning once on a hot grill or cast iron pan until it starts to get slightly charred. " +
                "In a small bowl mix the mayonnaise, sour cream and cilantro. Remove the corn from the grill and slather with " +
                "the mayonnaise mix. Squeeze the lime juice over the corn and heavily season with parmesan. Sprinkle with chili powder.");
        recipe5.addIngredient("mayonnaise", new Ingredient("mayonnaise", 0.5, Unit.CUP));
        recipe5.addIngredient("sour cream", new Ingredient("sour cream", 0.5, Unit.CUP));
        recipe5.addIngredient("chopped cilantro", new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        recipe5.addIngredient("parmesan", new Ingredient("parmesan", 1, Unit.CUP));
        recipe5.addIngredient("lime", new Ingredient("lime", 1, Unit.UNIT));
        recipe5.addIngredient("red chile powder", new Ingredient("red chile powder", 1, Unit.UNIT));
        recipe5.setPathToPicture("https://crolove.pl/wp-content/uploads/2014/02/jedzenie-w-chorwacji-2018.jpg");

        Recipe recipe6 = new Recipe("recipe6", Category.BREAKFAST, "Remove the husks of the corn leaving " +
                "the core attached. Grill the corn turning once on a hot grill or cast iron pan until it starts to get slightly charred. " +
                "In a small bowl mix the mayonnaise, sour cream and cilantro. Remove the corn from the grill and slather with " +
                "the mayonnaise mix. Squeeze the lime juice over the corn and heavily season with parmesan. Sprinkle with chili powder.");
        recipe6.addIngredient("mayonnaise", new Ingredient("mayonnaise", 0.5, Unit.CUP));
        recipe6.addIngredient("sour cream", new Ingredient("sour cream", 0.5, Unit.CUP));
        recipe6.addIngredient("chopped cilantro", new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        recipe6.addIngredient("parmesan", new Ingredient("parmesan", 1, Unit.CUP));
        recipe6.addIngredient("lime", new Ingredient("lime", 1, Unit.UNIT));
        recipe6.addIngredient("red chile powder", new Ingredient("red chile powder", 1, Unit.UNIT));
        recipe6.setPathToPicture("https://img01-olxpl.akamaized.net/img-olxpl/679301163_2_644x461_catering-domowy-domowe-jedzenie-dodaj-zdjecia_rev001.jpg");

        recipesList.add(recipe1);
        recipesList.add(recipe2);
        recipesList.add(recipe3);
        recipesList.add(recipe4);
        recipesList.add(recipe5);
        recipesList.add(recipe6);

        ingredientsList.add(new Ingredient("mayonnaise", 0.5, Unit.CUP));
        ingredientsList.add(new Ingredient("sour cream", 0.5, Unit.CUP));
        ingredientsList.add(new Ingredient("chopped cilantro", 0.25, Unit.CUP));
        ingredientsList.add(new Ingredient("parmesan", 1, Unit.CUP));
        ingredientsList.add(new Ingredient("lime", 1, Unit.UNIT));
        ingredientsList.add(new Ingredient("red chile powder", 1, Unit.UNIT));
    }

    public List<Recipe> getRecipesList() {
        return recipesList;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }
}
