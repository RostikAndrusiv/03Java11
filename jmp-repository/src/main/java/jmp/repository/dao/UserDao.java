package jmp.repository.dao;

import jmp.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jmp.repository.hibernate.HibernateUtil;

import java.util.List;

public class UserDao {
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createNativeQuery("Select * from user", User.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
