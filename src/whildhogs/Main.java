package whildhogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    // CREATE FIRST TEST-RECIPE
        Recipe recipe1 = new Recipe("Teriyaki Chicken",
                "1. Mix together the mirin, soy sauce, and ginger in a large zip-top freezer bag. Add the chicken thighs, force the air from the bag and seal it closed. Massage the chicken to distribute the marinade then refrigerate the chicken for 8 to 12 hours, flipping it over a few times to distribute the marinade.\n" +
                        "2. To cook the chicken, drain the chicken over a saucepan and set the pan over medium heat reduce the marinade it comes to a full boil, then reduce the heat and cook it longer, until it’s slightly boiled down.\n" +
                        "3. Heat a grill pan or cast-iron skillet over high heat and add the chicken thighs, skin side down, cooking off only the amount of thighs in the pan so they are not crowded – I did three at a time in mine.\n" +
                        "4. Sear the thighs for 2-3 minutes on each side, then cover, and cook for 6 minutes.\n" +
                        "5. Remove the cover, wipe the condensation off the underside of the cover with a kitchen towel, flip the thighs over, cover, and cook for another 6 minutes.\n" +
                        "6. Uncover the chicken and finish cooking them for about 3 minutes on each side, brushing and basting the chicken with the reserved marinade as you go, until the skin and meat have darkened.\n" +
                        "Remove from the pan and cook off the remaining chicken thighs the same way.\n" +
                        "Storage: Leftovers are especially good to have in the refrigerator for a few days, and I used mine to make rice bowls with kimchi. Nancy suggests sandwiches, too.");

        recipe1.addToKeywords("Teriyaki");
        recipe1.addToKeywords("Chicken");
        recipe1.addToKeywords("Dinner");

        recipe1.putIntoIngredientsMap(new Ingredient("Mirin", 125, Units.ml));
        recipe1.putIntoIngredientsMap(new Ingredient("Soy sause", 125, Units.g));
        recipe1.putIntoIngredientsMap(new Ingredient("Ginger (fresh)", 5, Units.cm));
        recipe1.putIntoIngredientsMap(new Ingredient("Chicken thighs", 900, Units.g));

        // CREATE SECOND TEST-RECIPE
        Recipe recipe2 = new Recipe("Chicken Vesuvio", "test2");

        recipe2.addToKeywords("Chicken");
        recipe2.addToKeywords("Dinner");

        recipe2.putIntoIngredientsMap(new Ingredient("Olive oil", 0.5, Units.cup));
        recipe2.putIntoIngredientsMap(new Ingredient("Garlic", 5, Units.cloves));
        recipe2.putIntoIngredientsMap(new Ingredient("Chicken", 600, Units.g));
        recipe2.putIntoIngredientsMap(new Ingredient("Potato", 2, Units.unit));


        // CREATE THIRD TEST-RECIPE
        Recipe recipe3 = new Recipe("Chicken3 Vesuvio", "test3");

        recipe3.addToKeywords("Chicken");
        recipe3.addToKeywords("Lunch");

        recipe3.putIntoIngredientsMap(new Ingredient("Garlic", 2, Units.cloves));
        recipe3.putIntoIngredientsMap(new Ingredient("Chicken", 700, Units.g));
        recipe3.putIntoIngredientsMap(new Ingredient("Potato", 4, Units.unit));
        recipe3.putIntoIngredientsMap(new Ingredient("Olive oil", 1.5, Units.cup));



        // ADD TO RECIPES LIST
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        recipeList.add(recipe2);
        recipeList.add(recipe3);


        // PRINT RECIPES FOR TEST

        for (Recipe recipe : recipeList) {
            System.out.println(recipe.getTitle());
            System.out.println();
            System.out.println(recipe.getInstruction());
            System.out.println();
            System.out.println(recipe.getKeywords());
            System.out.println();

            for (Map.Entry entry : recipe.getIngredientsMap().entrySet()) {
                System.out.println(entry.getValue());
            }
        }





    }
}
