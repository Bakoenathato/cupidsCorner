package za.ac.cput.repository;
/*
    MatchingRepository.java
    MatchingRepository class
    Author: Thato Mokoena (222667087)
    Date 27 March 2024
*/

import za.ac.cput.domain.Matching;
import za.ac.cput.domain.Notification;

import java.util.ArrayList;
import java.util.List;

public class MatchingRepository implements IMatchingRepository{

    private static IMatchingRepository repository = null;

    private List<Matching> matchingList;

    private MatchingRepository(){
        matchingList = new ArrayList<>();
    }

    public static IMatchingRepository getRepository() {
        if (repository == null){
            repository = new MatchingRepository();
        }
        return repository;
    }


    @Override
    public Matching create(Matching matches) {
        boolean success = matchingList.add(matches);
        if(success){
            return matches;
        }
        return null;
    }

    @Override
    public Matching read(String Id) {
        for (Matching m: matchingList) {
            if(m.getConnections().equals(Id)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Matching update(Matching matching) {
        String conn = matching.getConnections();
        Matching oldConn = read(conn);
        if (oldConn == null) {
            return null;
        }
        if (delete(conn)){
            if (matchingList.add(matching)) {
                return matching;
            }
            return null;
        }
        return  null;
    }

    @Override
    public boolean delete(String Id) {
        Matching matchToDelete = read(Id);

        if (matchToDelete == null) {
            return false;
        }

        return matchingList.remove(matchToDelete);
    }

    @Override
    public List<Matching> getAll() {
        return matchingList;
    }
}
