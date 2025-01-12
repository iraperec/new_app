package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Repository
public class UserDAO {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;


    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Transactional
    public User show(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);

    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
