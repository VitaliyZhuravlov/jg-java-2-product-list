package com.jg.productlist.repository;
import com.jg.productlist.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateUserRepository implements UserRepository {

    private final SessionFactory sessionFactory;

    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public User findUserById(Long id) {
        User user = sessionFactory.getCurrentSession().find(User.class, id);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user = sessionFactory.getCurrentSession().find(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public List<User> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return currentSession.createQuery(query).getResultList();
    }
}
