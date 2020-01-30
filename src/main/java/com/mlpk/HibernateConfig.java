package com.mlpk;

import com.mlpk.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry svcRegistry;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory!=null){
            return sessionFactory;
        }
        Configuration cfg = new Configuration();
        Properties settings = new Properties();
        String host = System.getenv("DB_HOST");
        if(host==null){
            host = "localhost";
        }
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.URL, "jdbc:postgresql://" + host + ":5432/example");
        settings.put(Environment.USER, "postgres");
        settings.put(Environment.PASS, "example");
        settings.put(Environment.SHOW_SQL, true);
        //
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        cfg.setProperties(settings);

        //cfg.addAnnotatedClass(User.class);

        svcRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();

        MetadataSources sources = new MetadataSources(svcRegistry)
                .addAnnotatedClass(User.class);

        Metadata metadata = sources.buildMetadata();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        //sessionFactory = cfg.buildSessionFactory(svcRegistry);
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            StandardServiceRegistryBuilder.destroy(svcRegistry);
        }
    }
}
