package jmp.repository.dao;

import jmp.model.Subscription;
import jmp.repository.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubscriptionDao {

    public void save(Subscription subscription) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the subscription object
            session.save(subscription);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Subscription> getAllSubscriptions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNativeQuery(
                    "Select * from subscription", Subscription.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Subscription getSubscriptionByCardNumber(String bankCardNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            var subscriptionList = session.createNativeQuery(
                    "Select * from subscription where bankCard = :bankCardNumber", Subscription.class)
                    .setParameter("bankCardNumber", bankCardNumber)
                    .getResultList();
            if(subscriptionList.isEmpty()){
                return null;
            }
            return subscriptionList.get(0);
        } catch (Exception e) {
            return null;
        }
    }

}
