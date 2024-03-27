package za.ac.cput.repository;

import za.ac.cput.domain.Matching;

import java.util.ArrayList;
import java.util.List;

public class MatchingRepository implements IMatchingRepository{

    private static IMatchingRepository repository = null;

    private final List<Matching> matchingList;

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
    public Matching read(String ID) {
        for (Matching m: matchingList) {
            if(m.getConnections().equals(ID))
                return m;
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
    public boolean delete(String ID) {
        Matching matchToDelete = read(ID);

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
