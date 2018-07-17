package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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


}