package za.ac.cput.controller;
/* ReportController.java
ReportController Class
Author: Leonard Gabriel Langa (221069054)
Date: 24 May 2024
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Report;
import za.ac.cput.service.ReportService;
import za.ac.cput.service.UserprofileService;

import java.util.Set;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    public UserprofileService userprofileService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/create")
    public Report create(@RequestBody Report report)
    {
        userprofileService.create(report.getUserProfileReporter());
        userprofileService.create(report.getUserProfileReported());
        return reportService.create(report);
    }

    @GetMapping("/read/{reportId}")
    public Report read(@PathVariable Long reportId)
    {
        return reportService.read(reportId);
    }

    @PostMapping("/update")
    public Report update(@RequestBody Report report){
        userprofileService.create(report.getUserProfileReporter());
        userprofileService.create(report.getUserProfileReported());
        return reportService.update(report);
    }

    @DeleteMapping("/delete/{reportId}")
    public void delete(@PathVariable Long reportId){
        reportService.delete(reportId);
    }

    @GetMapping("/getall")
    public Set<Report> getAll()
    {
        return  reportService.getAll();
    }


}
