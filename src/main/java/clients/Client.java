package clients;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "client")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 500)
    private String name;

}



