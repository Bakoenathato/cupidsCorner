package za.ac.cput.repository;

/* ILocationRepository.java
   ILocationRepository class
   Author: Uzzaih Phumelela Ngogela 222135654
   Date: 26 March 2024
*/

import za.ac.cput.domain.Location;
import java.util.List;

public interface ILocationRepository extends IRepository<Location,String> {
    List<Location> getAll();
}
