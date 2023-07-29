package tickets;

import clients.Client;
import planets.Planet;

import java.sql.Timestamp;
import java.util.List;

interface ITicketDao {

       long create (Ticket ticket);

       Ticket getById (long id);

       void updateTicket (long id, Timestamp timestamp, Client client, Planet fromPlanet, Planet toPlanet);

        void deleteTicket (long id);

        List<Ticket> getAll ();


}
