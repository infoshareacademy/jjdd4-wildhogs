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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/upload-file")
@MultipartConfig
public class DataUploadServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(DataUploadServlet.class);

    @Inject
    private RecipeDao recipeDao;

    @Inject
    private UploadJSONFileBean uploadJSONFileBean;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("initialization");
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("do post");
        uploadDatabase(req, resp);
        deleteFile(getJason(req, resp));
        resp.sendRedirect("/welcome");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("do get");
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
        logger.info("Upload database");

        Map<String, Recipe> recipes = getMapOfMeals(req, resp);

        if (recipes == null) {
            logger.warn("getMapOfMeals method returned null");
            return;

        } else
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
    }

    private void deleteRecipe(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        final Long id = Long.parseLong(req.getParameter("id"));
        logger.info("Deleting data with id " + id);

        recipeDao.delete(id);
        if (recipeDao.findById(id) == null) {
            logger.info("Data with id " + id + " was succesfully deleted");
        } else {
            logger.warn("Something went wrong. Data piece was not deleted.");
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Loading all recipes.");

        final List<Recipe> result = recipeDao.findAll();

        if (result != null) {
            for (Recipe p : result) {
                resp.getWriter().write(p.toString() + "\n");
            }
        }else {
            logger.warn("Something went wrong. Null was returned.");

        }
    }

    private File getJason(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Getting JSON data from file.");

        Part filePart = null;

        try {
            filePart = req.getPart("json");
            File file = uploadJSONFileBean.uploadImageFile(filePart);
            logger.warn("File with JSON data properly loaded.");

            return file;
        } catch (ServletException e) {
            logger.warn("Something went wrong. JSON was not loaded.");
            e.printStackTrace();
        }
        return;
    }

    private Map<String, Recipe> getMapOfMeals(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Recipe> mapOfMeals = new LinkedHashMap<>();
        logger.info("Loading map of meals from JSON");
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
        logger.info("Deleting temporary file containing JSON");
        try {
            Files.deleteIfExists(file.toPath());
            logger.info("File was deleted");

        } catch (IOException e) {
            logger.warn("File was not deleted. Something went wrong.");
            e.printStackTrace();
        }

    }
}