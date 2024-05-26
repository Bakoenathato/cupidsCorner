package za.ac.cput.controller;
/*
    MatchingController.java
    MatchingController class
    Author: Thato Mokoena (222667087)
    Date 25 May 2024
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Match;
import za.ac.cput.service.MatchService;
import za.ac.cput.service.UserprofileService;
import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    public UserprofileService userprofileService;

    @Autowired
    public MatchService matchService;

    @PostMapping("/create")
    public Match create(@RequestBody Match match)
    {
        userprofileService.create(match.getProfile1());
        userprofileService.create(match.getProfile2());
        return matchService.create(match);
    }

    @GetMapping("/read/{matchId}")
    public Match read(@PathVariable Integer matchId)
    {
        return matchService.read(matchId);
    }

    @PostMapping("/update")
    public Match update(@RequestBody Match match){
        userprofileService.create(match.getProfile1());
        userprofileService.create(match.getProfile2());
        return matchService.create(match);
    }

    @DeleteMapping("/delete/{matchId}")
    public void delete(@PathVariable Integer matchId){
        matchService.delete(matchId);
    }

    @GetMapping("/getall")
    public List<Match> getAll()
    {
        return  matchService.getAll();
    }
}
