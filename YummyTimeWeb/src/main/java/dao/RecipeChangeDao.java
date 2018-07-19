package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RecipeChangeDao {

    @Inject
    RecipeDao recipeDao;

    @PersistenceContext
    private EntityManager entityManager;

    public void addRecipeToStatistic(String name){}

    public boolean addRecipeToFavorites(String name) {
        Recipe recipe = recipeDao.getRecipeByName(name);
        if(recipe != null){
            Query query = entityManager.createQuery("UPDATE Recipe r SET r.likes = r.likes + 1 WHERE r.name = :name");
            query.setParameter("name", name);
            query.executeUpdate();
            return true;
        }
        return false;
    }

    public boolean addRecipeToShoppingList(String name) {
        return true;
    }
}
