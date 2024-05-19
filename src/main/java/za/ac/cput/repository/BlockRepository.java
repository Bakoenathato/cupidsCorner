package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Block;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, String> {


    //List<Block> findByBlocker(String blocker);
    //List<Block> findByBlocked(String blocked);
   // List<Block> findByBlockerAndBlocked(String blocker, String blocked);


}
