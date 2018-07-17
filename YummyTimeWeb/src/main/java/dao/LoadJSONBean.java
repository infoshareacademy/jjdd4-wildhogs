package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.JSONProvider;
import com.infoshareacademy.jjdd4.wildhogs.logic.RecipesProviderFromJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class LoadJSONBean {

    private final static String SETTINGS_FILE = "config.properties";


    public String getJSONPath() throws IOException {
        Properties settings = new Properties();

        settings.load(Thread.currentThread()
                .getContextClassLoader()
                .getResource(SETTINGS_FILE)
                .openStream());

        return settings.getProperty("jsonPath", "recipes.json");
    }

    public Map<String, Recipe> getMapOfMeals() {

        Map<String, Recipe> mapOfMeals = new LinkedHashMap<>();
        JSONObject jsonObject = null;
        try {
            System.out.println(getJSONPath()+ "  ================");
            jsonObject = JSONProvider.read("/home/mateuszmazur/jjdd4-wildhogs/YummyTimeWeb/src/main/resources/recipes.json");

        JSONArray recipesArray = (JSONArray) jsonObject.get("recipes");
        if (recipesArray != null) {
            for (Object recipe : recipesArray) {

                Recipe recipeCreated = RecipesProviderFromJSON.creator((JSONObject) recipe);
                if (recipeCreated != null) {
                    mapOfMeals.put(recipeCreated.getName(), recipeCreated);
                }
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapOfMeals;
    }
}
