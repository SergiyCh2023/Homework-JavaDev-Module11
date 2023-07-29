package planets;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanetCrudService implements  IPlanetDao{
    @Override
    public String create (String id, String planetName) {
        Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet newPlanet = new Planet ();
        newPlanet.setId(id);
        newPlanet.setName(planetName);
        session.persist(newPlanet);
        transaction.commit();
        session.close();
        return newPlanet.getId();
    }

    @Override
    public Planet getById (String id) {

         try(Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
             Query<Planet> query  = session.createQuery("From Planet where id =:id", Planet.class);
             query.setParameter("id", id);
             return query.stream().findFirst().orElse(null);
         }
    }

    @Override
    public void updatePlanetName (String id, String newName ) {
        Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet updatePlanet = session.get(Planet.class, id);
        updatePlanet.setName(newName);
        session.persist(updatePlanet);
        transaction.commit();
        session.close();
    }

    @Override
    public void deletePlanet (String id) {
        Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(session.get(Planet.class, id));
        transaction.commit();
        session.close();
    }

    @Override
    public List<Planet> getAll () {
        try(Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            List<Planet> planetList  = session.createQuery("From Planet", Planet.class).list();
            return planetList;
        }
    }


}
