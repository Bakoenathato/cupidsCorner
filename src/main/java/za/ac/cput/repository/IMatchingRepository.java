package za.ac.cput.repository;

import za.ac.cput.domain.Matching;

import java.util.List;

public interface IMatchingRepository extends IRepository<Matching, String> {

    List<Matching> getAll();
}
