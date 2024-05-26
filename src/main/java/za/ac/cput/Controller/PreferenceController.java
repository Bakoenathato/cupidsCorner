package za.ac.cput.controller;
/*
    PreferenceController.java
    PreferenceController class
    Author: Thato Mokoena (222667087)
    Date 25 May 2024
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Preference;
import za.ac.cput.service.PreferenceService;
import za.ac.cput.service.UserprofileService;

import java.util.List;

@RestController
@RequestMapping("/preference")
public class PreferenceController {

    @Autowired
    public UserprofileService userprofileService;

    @Autowired
    public PreferenceService preferenceService;

    @PostMapping("/create")
    public Preference create(@RequestBody Preference preference)
    {
        userprofileService.create(preference.getProfile());
        return preferenceService.create(preference);
    }

    @GetMapping("/read/{preferenceId}")
    public Preference read(@PathVariable Integer preferenceId)
    {
        return preferenceService.read(preferenceId);
    }

    @PostMapping("/update")
    public Preference update(@RequestBody Preference preference){
        userprofileService.create(preference.getProfile());
        return preferenceService.create(preference);
    }

    @DeleteMapping("/delete/{preferenceId}")
    public void delete(@PathVariable Integer preferenceId){
        preferenceService.delete(preferenceId);
    }

    @GetMapping("/getall")
    public List<Preference> getAll()
    {
        return  preferenceService.getAll();
    }
}
