package dao;

import com.infoshareacademy.jjdd4.wildhogs.data.User;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;


@Stateless
public class UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(User c) {
        entityManager.persist(c);
        return c.getId();
    }

    public User update(User c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final User c = entityManager.find(User.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM User s");

        return query.getResultList();
    }

    public User findByEmail(String email) {
        final TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}