package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.DisplayImage;
import za.ac.cput.factory.DisplayImageFactory;

@Repository
public interface DisplayImageRepository extends JpaRepository<DisplayImage, Long> {
}
