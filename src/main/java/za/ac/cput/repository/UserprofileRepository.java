package za.ac.cput.repo;
//UserprofileRepository.java
//UserProfile Repo class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

import za.ac.cput.domain.UserProfile;

import java.util.ArrayList;
import java.util.List;

public class UserprofileRepository implements UserRepository {
    private static UserRepository repository = null;
    private List<UserProfile> UserList;

    private UserprofileRepository() {
        UserList = new ArrayList<UserProfile>();
    }

    public static UserRepository getRepository() {
        if (repository == null) {
            repository = new UserprofileRepository();
        }
        return repository;
    }
    public UserProfile create(UserProfile user){
        boolean success=UserList.add(user);
        if(success)
            return user;
        else return null;

    }
    public UserProfile read(String id){
        for (UserProfile e:UserList){
            if(e.getID().equals(id))
                return e;

        }
        return null;
    }
    public UserProfile update(UserProfile user){
        String Id= user.getID();
        UserProfile oldID=read(Id);
        if(oldID==null)
            return null;
        if (delete(Id)){
            if (UserList.add(user))
                return user;
            return null;

        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        UserProfile UserToDelete=read(id);
        if (UserToDelete==null)
            return false;
        if (UserList.remove(UserToDelete)){
            return true;
        }
        return false;
    }
    public List<UserProfile> getall(){return UserList;}
}
