package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
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

    public Recipe getRecipeByName(String name) {
        final Query query = entityManager.createQuery("SELECT s FROM Recipe s WHERE s.name = :name");
        query.setParameter("name", name);
        try {
            Recipe recipe = (Recipe) query.getSingleResult();
            return recipe;
        }catch (NoResultException nre) {
            return null;
        }
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
        return null;
    }

    public List<Ingredient> getShoppingList() {
        return null;
    }

    public List<BlockRecipe> getRecipeInShoppingList() {
        return null;
    }

    private List<BlockRecipe> changeRecipiesToBlocks(List<Recipe> recipes) {
        return recipes.stream().map(r -> new BlockRecipe(r.getName(), r.getPathToPicture())).collect(Collectors.toList());
    }
}