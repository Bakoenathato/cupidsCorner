package za.ac.cput.repository;

import za.ac.cput.domain.UserProfile;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface UserRepository extends IRepository<UserProfile,String> {

    List<UserProfile> getall();
}
