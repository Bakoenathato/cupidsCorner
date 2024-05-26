package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.DisplayImage;
import za.ac.cput.service.DisplayImageService;

import java.util.Set;


@RestController
@RequestMapping("/displayimage")
public class DisplayImageController {
    @Autowired
    private DisplayImageService displayImageService;

    @PostMapping("/create")
    public DisplayImage create(@RequestBody DisplayImage displayImage) {return displayImageService.create(displayImage);}

    @GetMapping("/read/{displayImage}")
    public DisplayImage read(@PathVariable Long displayImageId) {return displayImageService.read(displayImageId);}

    @PostMapping("/update")
    public DisplayImage update(@RequestBody DisplayImage displayImage){return displayImageService.update(displayImage);}

    @DeleteMapping("/delete/{displayImageId}")
    public void delete(@PathVariable Long displayImageId) {displayImageService.delete(displayImageId);
    }

    @GetMapping("/getall")
    public Set<DisplayImage> getall(){return  displayImageService.getall();
    }
}




