package com.jg.productlist.repository;
import com.jg.productlist.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class HibernateProductRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product save(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    @Override
    public Product findProductById(Long id) {
        Product product = sessionFactory.getCurrentSession().find(Product.class,id);
        return product;
    }

    @Override
    public void delete(Long id) {
        Product product = sessionFactory.getCurrentSession().find(Product.class,id);
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public List<Product> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        return currentSession.createQuery(query).getResultList();
    }

    @Override
    public Product findByName(String name) {
       Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
               .add(Restrictions.eq("name", name))
               .uniqueResult();
       return product;
    }
}
