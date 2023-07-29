package tickets;

import clients.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import planets.Planet;

import java.sql.Timestamp;
import java.util.List;

public class TicketCrudService implements ITicketDao {

        @Override
        public long create(Ticket ticket) {
            Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            session.close();
            return ticket.getId();
        }

        @Override
        public Ticket getById(long id) {
            try (Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
                Query<Ticket> query = session.createQuery("from Ticket where id =:id", Ticket.class);
                query.setParameter("id", id);
                return query.stream().findFirst().orElse(null);
            }

        }

        @Override
        public void deleteTicket (long id) {
            Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(session.get(Ticket.class, id));
            transaction.commit();
            session.close();
        }

        public void updateTicket (long id, Timestamp timestamp, Client client, Planet fromPlanet, Planet toPlanet) {
            Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
                Ticket updateTicket = session.get(Ticket.class, id);
                updateTicket.setCreated_at(timestamp);
                updateTicket.setClient(client);
                updateTicket.setFromPlanets(fromPlanet);
                updateTicket.setToPlanets(toPlanet);
                session.persist(updateTicket);
                transaction.commit();
                session.close();

        }

        @Override
        public List<Ticket> getAll() {
            try(Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
                List<Ticket> ticketList  = session.createQuery("From Ticket", Ticket.class).list();
                return ticketList;
            }
        }


}
