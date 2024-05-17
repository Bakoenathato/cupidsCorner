package za.ac.cput.repository;
/*IUserProfileRepository.java
//UserProfile Repo class
//Author:Braedon Sidney Mullins(222821825)
Date:27 March 2024*/

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.UserProfile;

import java.util.List;
@Repository

public interface IUserProfileRepository extends IRepository<UserProfile,String> {

}
