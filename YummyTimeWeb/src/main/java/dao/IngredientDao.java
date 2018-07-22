package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class IngredientDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Ingredient c) {
        entityManager.persist(c);
        return c.getId();
    }

    public Ingredient update(Ingredient c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final Ingredient c = entityManager.find(Ingredient.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    public Ingredient findById(Long id) {
        return entityManager.find(Ingredient.class, id);
    }

    public List<Ingredient> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Ingredient s");

        return query.getResultList();
    }
}
