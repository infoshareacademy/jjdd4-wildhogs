package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.Fridge;
import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class RecipeDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Recipe c) {
        entityManager.persist(c);
        return c.getId();
    }

    public Recipe update(Recipe c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final Recipe c = entityManager.find(Recipe.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    public Recipe findById(Long id) {
        return entityManager.find(Recipe.class, id);
    }

    public List<Recipe> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Recipe s");


        return query.getResultList();
    }

    public List<BlockRecipe> getRecipesFromCategory(Category category, int limit) {
        final Query query = entityManager.createQuery("SELECT s FROM Recipe s WHERE s.category = :category");
        query.setParameter("category", category);
        query.setMaxResults(limit);
        return changeRecipiesToBlocks(query.getResultList());
    }

    public List<BlockRecipe> getRecipesFromCategory(Category category) {
        return getRecipesFromCategory(category, 20);
    }

    public List<BlockRecipe> getFavouriteList() {
        final Query query = entityManager.createQuery("SELECT s FROM Recipe s ORDER BY s.likes DESC ");
        query.setMaxResults(3);
        return changeRecipiesToBlocks(query.getResultList());
    }

    public List<BlockRecipe> getRecipesForProducts(List<String> fridgeList) {
        Fridge fridge = new Fridge();
        List<Long> sortedRecipesId = fridge.showFilterRecipe(findAll(), fridgeList);
        if (sortedRecipesId == null) {
            return  new ArrayList<>();
        }

        List<Recipe> listOfRecipes = sortedRecipesId.stream()
                   .map((Long r) -> findById(r))
                   .collect(Collectors.toList());
        return changeRecipiesToBlocks(listOfRecipes);
    }

    public List<BlockRecipe> changeRecipiesToBlocks(List<Recipe> recipes) {
        return recipes.stream().map(r -> new BlockRecipe(r.getName(), r.getPathToPicture(), r.getId()))
                .collect(Collectors.toList());
    }

    public void categoryStatistic() {
        Map<String, Long> statisticCategory = new HashMap<>();
        Query query = entityManager.createQuery("SELECT r.category, SUM(r.timesClicked) FROM Recipe r GROUP BY r.category");

        for (Object result: query.getResultList()) {
            Object[] actualResult = (Object[])result;
            statisticCategory.put(actualResult[0].toString(), (Long)actualResult[1]);
        }
    }
}