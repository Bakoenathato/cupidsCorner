package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import domain.Block;

import java.util.List;

@Repository
public class BlockRepository extends JpaRepository<Block, String> {


    List<Block> findByBlocker(String blocker);
    List<Block> findByBlocked(String blocked);
    List<Block> findByBlockerAndBlocked(String blocker, String blocked);
}