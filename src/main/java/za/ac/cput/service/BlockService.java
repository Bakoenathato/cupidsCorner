package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Block;
import za.ac.cput.factory.BlockFactory;
import za.ac.cput.repository.BlockRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlockService implements IBlockService {
    private final BlockRepository blockRepository;

    @Autowired
    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public Block save(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public Optional<Block> findById(Long Id) {
        return blockRepository.findById(String.valueOf(Id));
    }

    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public Block update(Long Id, Block block) {
        Optional<Block> existingBlockOpt = blockRepository.findById(String.valueOf(Id));
        if (existingBlockOpt.isPresent()) {
            Block existingBlock = existingBlockOpt.get();
            Block updatedBlock = new Block.Builder()
                    .setId(existingBlock.getId())
                    .setBlocker(block.getBlocker())
                    .setBlocked(block.getBlocked())
                    .setTimestamp(block.getTimestamp())
                    .build();
            return blockRepository.save(updatedBlock);
        } else {
            throw new IllegalArgumentException("Block with ID " + Id + " does not exist.");
        }
    }

    @Override
    public void deleteById(Long Id) {
        blockRepository.deleteById(String.valueOf(Id));
    }

    @Override
    public List<Block> findByBlocker(String blocker) {
        return blockRepository.findByBlocker(blocker);
    }

    @Override
    public List<Block> findByBlocked(String blocked) {
        return blockRepository.findByBlocked(blocked);
    }

    @Override
    public List<Block> findByBlockerAndBlocked(String blocker, String blocked) {
        return blockRepository.findByBlockerAndBlocked(blocker, blocked);
    }

}
