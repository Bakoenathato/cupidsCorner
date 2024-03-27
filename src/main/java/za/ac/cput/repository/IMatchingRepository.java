package za.ac.cput.repository;
/*
    IMatchingRepository.java
    IMatchingRepository class
    Author: Thato Mokoena (222667087)
    Date 27 March 2024
*/

import za.ac.cput.domain.Matching;

import java.util.List;

public interface IMatchingRepository extends IRepository<Matching, String> {

    List<Matching> getAll();
}
