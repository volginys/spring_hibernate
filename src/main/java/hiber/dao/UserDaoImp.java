package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public User findByCar(Car car) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User where car.model =:model and car.series =:series",User.class)
                .setParameter("model", car.getModel())
                .setParameter("series", car.getSeries()).getSingleResult();
    }
}
