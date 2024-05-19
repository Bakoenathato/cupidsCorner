package za.ac.cput.service;

import za.ac.cput.domain.Report;

import java.util.Set;

public interface IReportService extends IService <Report,Long>{
    Set<Report> getAll();
}
