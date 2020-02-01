package com.mlpk.repos;

import com.mlpk.utils.Encryption;
import com.mlpk.utils.HibernateConfig;
import com.mlpk.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepository {

    public User login(String user, String password) {
        try (Session s = HibernateConfig.getSessionFactory().openSession()) {
            // Create CriteriaBuilder
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> root = criteria.from(User.class);
            criteria.where(builder.and(
                    builder.equal(root.get("userId"), user),
                    builder.equal(root.get("password"), password)
            ));
            List<User> users = s.createQuery(criteria).getResultList();
            return users.size() > 0 ? users.get(0) : null;
        }
    }

    public void saveUser(String username, String password) {
        if (username == null || password == null) {
            return;
        }
        try (Session s = HibernateConfig.getSessionFactory().openSession()) {
            Transaction tx = s.beginTransaction();
            User user = new User();
            user.setUserId(username);
            user.setPassword(Encryption.encrypt(password));
            s.save(user);
            tx.commit();
            assert user.getId() != null;
        }
    }
}
