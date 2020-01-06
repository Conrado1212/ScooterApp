package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.model.Scooter;

import java.util.List;

public class ScooterDAOImpl implements IScooterDAO {
   // private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    @Autowired
    SessionFactory sessionFactory;

    public ScooterDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addScooter(Scooter scooter){
       // Session session = factory.openSession();
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(scooter);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Scooter getScooter(int Id){
        //Session session = factory.openSession();
        Session session = this.sessionFactory.openSession();
        Scooter scooter =
                (Scooter) session.createQuery("FROM pl.edu.wszib.model.Scooter WHERE id = " + Id).uniqueResult();

        session.close();
        return scooter;
    }

    @Override
    public Scooter getUpdate(int Id, Scooter scooter){
       // Session session = factory.openSession();
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(Scooter.class,Id);

            session.update(scooter);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally{
            session.close();
        }
        return scooter;
    }
    @Override
    public Scooter removeScooterId(int Id){
       // Session session = factory.openSession();
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Scooter scooter =
                    (Scooter) session.get(Scooter.class, Id);
            session.delete(scooter);
            //wiecej operacji
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();//wycofanie czynnosci
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public List<Scooter> getAllScooterXiaomi() {
       // Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();

        List<Scooter> allScooterXiomi =
                session.createQuery("FROM pl.edu.wszib.model.Scooter Where brand = 'Xiaomi'").list();

        return allScooterXiomi;
    }
    @Override
    public List<Scooter> getAllScooters() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Scooter> allScooter = session.createQuery("FROM pl.edu.wszib.model.Scooter ").list();

        return allScooter;
    }
    @Override
    public List<Scooter> getAllScooterFiat() {
        //Session session = factory.openSession();
    Session session = this.sessionFactory.openSession();
        List<Scooter> allScooterFiat =
                session.createQuery("FROM pl.edu.wszib.model.Scooter Where brand = 'Fiat'").list();

        return allScooterFiat;

    }
}
