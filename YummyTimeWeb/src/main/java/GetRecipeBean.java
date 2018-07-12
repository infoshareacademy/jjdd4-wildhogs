import javax.enterprise.context.RequestScoped;

import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;

@RequestScoped
public class GetRecipeBean {

    private MealCreator mealCreator = new MealCreator();
    private Recipe recipe;

    public Recipe getRecipeForWeb(String nameRecipe){

                recipe = mealCreator.getMapOfMeals().get(nameRecipe);

        return recipe;
    }
}
