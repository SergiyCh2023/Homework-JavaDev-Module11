import clients.Client;
import clients.ClientCrudService;
import planets.Planet;
import planets.PlanetCrudService;
import tickets.Ticket;
import tickets.TicketCrudService;

import java.sql.SQLException;
import java.sql.Timestamp;


public class Main {

    public static void main(String[] args) throws SQLException {

        ClientCrudService clientCrud = new ClientCrudService();
        PlanetCrudService planetCrud = new PlanetCrudService();
        TicketCrudService ticketCrud = new TicketCrudService();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


//        Client clientNull = null;
//        Planet planetNull = null;
//
//
//        Ticket newTicket = new Ticket();
//        newTicket.setClient(clientCrud.getById(7l));
//        newTicket.setCreated_at(timestamp);
//        newTicket.setFromPlanets(planetCrud.getById("R2D2"));
//        newTicket.setToPlanets(planetCrud.getById("X1"));
//
//        ticketCrud.create(newTicket);
//
//        for (Ticket current : ticketCrud.getAll()) {
//            System.out.println("currentTicket = " + current);
//        }

//          System.out.println(ticketCrud.getById(13l));


//        System.out.println("*****************************************************");

//        ticketCrud.deleteTicket(5l);


//        ticketCrud.updateTicket(10l, timestamp, clientCrud.getById(1l),
//        planetCrud.getById("BABYLON5"),  planetCrud.getById("SECTOR_CAPSULAR"));

            for (Ticket current : ticketCrud.getAll()) {
            System.out.println("current = " + current);
        }

    }
}