package servlet;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.JSONProvider;
import com.infoshareacademy.jjdd4.wildhogs.logic.RecipesProviderFromJSON;
import dao.IngredientDao;
import dao.RecipeDao;
import dao.UploadJSONFileBean;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/upload-file")
@MultipartConfig
public class DataUploadServlet extends HttpServlet {

    @Inject
    private RecipeDao recipeDao;

    @Inject
    private IngredientDao ingredientDao;

    @Inject
    private UploadJSONFileBean uploadJSONFileBean;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        uploadDatabase(req, resp);
        deleteFile(getJason(req, resp));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }
        if (action.equals("findAll")) {
            findAll(req, resp);
        } else if (action.equals("delete")) {
            deleteRecipe(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
    }

    private void uploadDatabase(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Recipe> recipes = getMapOfMeals(req, resp);


        for (Recipe r : recipes.values()) {

            Recipe recipe = new Recipe();

            recipe.setName(r.getName());
            recipe.setPathToPicture(r.getPathToPicture());
            recipe.setCategory(r.getCategory());
            recipe.setDescription(r.getDescription());
            recipe.setIngredientsList(r.getIngredientsList());
            recipe.setPathToPicture(r.getPathToPicture());

            for (Ingredient i : recipe.getIngredientsList()) {
                i.setRecipe(recipe);
            }

            recipeDao.save(recipe);
        }
        findAll(req, resp);
    }

    private void deleteRecipe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));

        recipeDao.delete(id);
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Recipe> result = recipeDao.findAll();
        for (Recipe p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }

    private File getJason(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Part filePart = null;

        try {
            filePart = req.getPart("json");
        } catch (ServletException e) {
            e.printStackTrace();
        }
        File file = uploadJSONFileBean.uploadImageFile(filePart);

        return file;
    }

    private Map<String, Recipe> getMapOfMeals(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Recipe> mapOfMeals = new LinkedHashMap<>();
        JSONObject jsonObject = JSONProvider.read(getJason(req, resp).toPath().toString());
        JSONArray recipesArray = (JSONArray) jsonObject.get("recipes");
        if (recipesArray != null) {
            for (Object recipe : recipesArray) {

                Recipe recipeCreated = RecipesProviderFromJSON.creator((JSONObject) recipe);
                if (recipeCreated != null) {
                    mapOfMeals.put(recipeCreated.getName(), recipeCreated);
                }
            }
        }
        return mapOfMeals;
    }

    private void deleteFile(File file) {
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}