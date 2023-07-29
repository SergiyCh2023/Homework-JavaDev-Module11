package planets;

import java.util.List;

public interface IPlanetDao {

    String create (String id, String planetName);

    Planet getById (String id) ;

    void updatePlanetName (String id, String newName);

    void deletePlanet (String id);

    List<Planet> getAll ();

}
