package clients;

import org.hibernate.Session;
import planets.Planet;

import java.util.List;

interface IClientDao {

       Client create (String clientName);

       Client getById (long id);

       void updateClientName (long id, String newName);

       void deleteClient (long id);

       List<Client> getAll ();




}
