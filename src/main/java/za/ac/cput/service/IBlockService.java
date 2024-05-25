package za.ac.cput.service;

import za.ac.cput.domain.Block;

import java.util.List;

public interface IBlockService extends IService<Block, Long> {
    List<Block> findByBlocker(String blocker);
    List<Block> findByBlocked(String blocked);
    List<Block> findByBlockerAndBlocked(String blocker, String blocked);
}
