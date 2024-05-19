package za.ac.cput.service;
/* ReportService.java
ReportService class
Author: Leonard Gabriel Langa (221069054)
Date: 17 May 2024
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Report;
import za.ac.cput.repository.ReportRepository;
import za.ac.cput.repository.UserprofileRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReportService implements IReportService{

    public UserprofileRepository userprofileRepository;
    public ReportRepository reportRepository;

    @Autowired
    ReportService(UserprofileRepository userprofileRepository,ReportRepository reportRepository){
        this.userprofileRepository = userprofileRepository;
        this.reportRepository = reportRepository;
    }
    @Override
    public Report create(Report report) {
        userprofileRepository.save(report.getUserProfileReporter());
        userprofileRepository.save(report.getUserProfileReported());
        return reportRepository.save(report);
    }

    @Override
    public Report read(Long reportId) {
        return reportRepository.findById(reportId).orElse(null);
    }

    @Override
    public Report update(Report report) {
        userprofileRepository.save(report.getUserProfileReporter());
        userprofileRepository.save(report.getUserProfileReported());
        return reportRepository.save(report);
    }

    @Override
    public void delete(Long reportId) {
        reportRepository.deleteById(reportId);
    }

    @Override
    public Set<Report> getAll() {
        return reportRepository.findAll().stream().collect(Collectors.toSet());
    }
}
