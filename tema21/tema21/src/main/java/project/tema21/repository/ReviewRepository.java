package project.tema21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.tema21.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
