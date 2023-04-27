package api.familytree.service;

import api.familytree.dto.PeopleDto;
import api.familytree.entity.PeopleEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class PeopleService {
    void salvar(PeopleDto peopleDto);

    Optional<PeopleEntity> findUserById(Long id);

    ResponseEntity<PeopleEntity> updateUser(long id);

    PeopleDto updateByUserId(UserUpdateForm form, Long id);

    void deleteById(Long id);
}
