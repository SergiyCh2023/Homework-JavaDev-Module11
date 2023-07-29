package clients;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class ClientCrudService implements IClientDao{

    @Override
    public Client create (String clientName) {
        Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client newClient = new Client();
        newClient.setName(clientName);
        session.persist(newClient);
        transaction.commit();
        session.close();
        return newClient;
    }

    @Override
    public Client getById(long id) {

        try (Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("From Client where id =:id", Client.class);
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);

        }
    }

    @Override
    public void updateClientName (long id, String newName ) {
        Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client updateClient = session.get(Client.class, id);
        updateClient.setName(newName);
        session.persist(updateClient);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteClient (long id) {
        Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(session.get(Client.class, id));
        transaction.commit();
        session.close();
    }


    @Override
    public List<Client> getAll() {
        try(Session session = hibernate.HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
                List<Client> clientList  = session.createQuery("From Client", Client.class).list();
                return clientList;
            }
        }

    }


//    @Override
//    public String getById(long id) {
//        return null;
//    }
//
//    @Override
//    public void setName(long id, String name) {
//
//    }
//
//    @Override
//    public void deleteById(long id) {
//
//    }
//
//    @Override
//    public List<Client> listAll() {
//        return null;
//    }

