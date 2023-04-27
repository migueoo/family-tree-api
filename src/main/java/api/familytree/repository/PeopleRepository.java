package api.familytree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.familytree.entity.PeopleEntity;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {

        PeopleEntity findByEmail(String email);
}
