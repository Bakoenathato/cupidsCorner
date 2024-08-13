package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Like;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.service.LikeService;
import za.ac.cput.service.UserprofileService;

import java.util.List;
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {
    @Autowired
    private UserprofileService Service;

    @PostMapping("/create")
    public UserProfile create(@RequestBody UserProfile userProfile) {
        return Service.create(userProfile);
    }

    @GetMapping("/read/{id}")
    public UserProfile read(@PathVariable String id) {
        return Service.read(id);
    }

    @PutMapping("/update")
    public UserProfile update(@RequestBody UserProfile userProfile) {
        return Service.update(userProfile);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        Service.delete(id);
    }

    @GetMapping("/getall")
    public List<UserProfile> getAll() {
        return Service.getall();
    }
}
