package ie.james;

import db.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.Map;

/**
 * Created by User on 05/11/2015.
 */
@Repository
public class DAOImpl implements DAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void save(Exhibit exhibit) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.persist(exhibit);

        for(Map<String, Image> images:exhibit.getImages()){
            images.values().forEach(session::persist);
        }

        for(Participation p: exhibit.getParticipants()){
            session.persist(p);
            session.persist(p.getRole());
            session.persist(p.getParticipant());
        }

        transaction.commit();


    }

    @Override
    public void update(Exhibit exhibit) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(exhibit);
        transaction.commit();

    }

    @Override
    public void delete(String id ) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Exhibit exhibit = (Exhibit) session.load(Exhibit.class, id);
        if(null != exhibit){
            session.delete(exhibit);
        }
        transaction.commit();


    }

    @Override
    public Exhibit findExhibitById(String id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Exhibit exhibit = session.load(Exhibit.class,id);
        transaction.commit();
        return exhibit;
    }

}
