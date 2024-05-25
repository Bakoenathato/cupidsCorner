package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Location;
import za.ac.cput.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public Location create(@RequestBody Location location) {
        return locationService.create(location);
    }

    @GetMapping("/read/{postalCode}")
    public Location read(@PathVariable Long postalCode) {
        return locationService.read(postalCode);
    }

    @PutMapping("/update")
    public Location update(@RequestBody Location location) {
        return locationService.update(location);
    }

    @DeleteMapping("/delete/{postalCode}")
    public void delete(@PathVariable Long postalCode) {
        locationService.delete(postalCode);
    }

    @GetMapping("/getall")
    public List<Location> getAll() {
        return locationService.getAll();
    }
}