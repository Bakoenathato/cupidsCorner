package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserProfile;
@Repository
public interface UserprofileRepository extends JpaRepository<UserProfile,String>{;

}
