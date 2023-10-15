package project.tema21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.tema21.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
