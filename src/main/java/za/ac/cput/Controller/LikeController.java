package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Like;
import za.ac.cput.service.GenderService;
import za.ac.cput.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService Service;

    @PostMapping("/create")
    public Like create(@RequestBody Like like) {
        return Service.create(like);
    }

    @GetMapping("/read/{id}")
    public Like read(@PathVariable String id) {
        return Service.read(id);
    }

    @PutMapping("/update")
    public Like update(@RequestBody Like like) {
        return Service.update(like);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        Service.delete(id);
    }

    @GetMapping("/getall")
    public List<Like> getAll() {
        return Service.getall();
    }
}

