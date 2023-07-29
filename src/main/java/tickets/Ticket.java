package tickets;

import clients.Client;
import jakarta.persistence.*;
import lombok.Data;
import planets.Planet;

import java.sql.Timestamp;


@Data
@Entity
@Table (name = "ticket")
public class Ticket {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column (name = "id")
   private long id;

   @Column
   private Timestamp created_at;

   @ManyToOne
   @JoinColumn(name="client_id", nullable=false)
   private Client client;

   @ManyToOne
   @JoinColumn (name = "from_planet_id", nullable=false)
   private Planet fromPlanets;

   @ManyToOne
   @JoinColumn (name = "to_planet_id", nullable=false)
   private Planet toPlanets;

}



