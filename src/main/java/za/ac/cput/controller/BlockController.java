package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Block;
import za.ac.cput.service.BlockService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blocks")
public class BlockController {

    private final BlockService blockService;

    @Autowired
    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @PostMapping
    public Block createBlock(@RequestBody Block block) {
        return blockService.save(block);
    }

    @GetMapping("/{id}")
    public Optional<Block> getBlockById(@PathVariable Long id) {
        return blockService.findById(id);
    }

    @GetMapping
    public List<Block> getAllBlocks() {
        return blockService.findAll();
    }

    @PutMapping("/{id}")
    public Block updateBlock(@PathVariable Long id, @RequestBody Block block) {
        return blockService.update(id, block);
    }

    @DeleteMapping("/{id}")
    public void deleteBlock(@PathVariable Long id) {
        blockService.deleteById(id);
    }

    @GetMapping("/blocker/{blocker}")
    public List<Block> getBlocksByBlocker(@PathVariable String blocker) {
        return blockService.findByBlocker(blocker);
    }

    @GetMapping("/blocked/{blocked}")
    public List<Block> getBlocksByBlocked(@PathVariable String blocked) {
        return blockService.findByBlocked(blocked);
    }

    @GetMapping("/search")
    public List<Block> getBlocksByBlockerAndBlocked(@RequestParam String blocker, @RequestParam String blocked) {
        return blockService.findByBlockerAndBlocked(blocker, blocked);
    }
}