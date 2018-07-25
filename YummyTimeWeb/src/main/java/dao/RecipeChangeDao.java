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
    private RecipeDao recipeDao;

    @PersistenceContext
    private EntityManager entityManager;

    public void addRecipeToStatistic(Long recipeId) {
    }

    public boolean addRecipeToFavorites(Long recipeId) {
        Recipe recipe = recipeDao.findById(recipeId);
        if(recipe != null){
            Query query = entityManager.createQuery("UPDATE Recipe r SET r.likes = r.likes + 1 WHERE r.id = :id");
            query.setParameter("id", recipeId);
            query.executeUpdate();
            return true;
        }
        return false;
    }
}
