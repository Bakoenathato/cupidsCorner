package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Gender;
import za.ac.cput.service.GenderService;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping("/create")
    public Gender create(@RequestBody Gender gender) {
        return genderService.create(gender);
    }

    @GetMapping("/read/{id}")
    public Gender read(@PathVariable Long id) {
        return genderService.read(id);
    }

    @PutMapping("/update")
    public Gender update(@RequestBody Gender gender) {
        return genderService.update(gender);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        genderService.delete(id);
    }

    @GetMapping("/getall")
    public List<Gender> getAll() {
        return genderService.getAll();
    }
}