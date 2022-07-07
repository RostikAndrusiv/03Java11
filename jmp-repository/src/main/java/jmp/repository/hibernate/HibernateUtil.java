package jmp.repository.hibernate;

import jmp.model.BankCard;
import jmp.model.Subscription;
import jmp.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
            Configuration configuration = new Configuration();

            Properties settings = new Properties();
            settings.put(AvailableSettings.DRIVER, "org.h2.Driver");
            settings.put(AvailableSettings.URL, "jdbc:h2:mem:test");
            settings.put(AvailableSettings.USER, "root");
            settings.put(AvailableSettings.PASS, "root");
            settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
            settings.put(AvailableSettings.SHOW_SQL, "true");
            settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(AvailableSettings.HBM2DDL_AUTO, "create-drop");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Subscription.class);
            configuration.addAnnotatedClass(BankCard.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
            }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}