package com.mlpk.repos;

import com.mlpk.HibernateConfig;
import com.mlpk.models.Package;
import com.mlpk.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PackageRepository {

    public boolean createPackage(long userId, String name, String language) {
        if (name == null || language == null) {
            return false;
        }
        try (Session s = HibernateConfig.getSessionFactory().openSession()) {
            Transaction tx = s.beginTransaction();
            Package pkg = new Package();
            pkg.setName(name);
            pkg.setLanguage(language);
            pkg.setAuthor(userId);
            s.save(pkg);
            tx.commit();
            assert pkg.getId() != null;
        }
        return true;
    }

    public List<Package> getPackages() {
        try (Session s = HibernateConfig.getSessionFactory().openSession()) {

            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Package> cq = builder.createQuery(Package.class);
            Root<Package> root = cq.from(Package.class);
            CriteriaQuery<Package> all = cq.select(root);

            List<Package> pkgs = s.createQuery(all).getResultList();
            return pkgs;
        }

    }
}
