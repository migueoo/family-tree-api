package api.familytree.service.impl;

import api.familytree.dto.PeopleDto;
import api.familytree.entity.PeopleEntity;
import api.familytree.exception.BusinessException;
import api.familytree.repository.PeopleRepository;
import api.familytree.service.PeopleService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class PeopleServiceImpl extends PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void salvar(PeopleDto peopleDto) {
        try {
            PeopleEntity peopleEntity = new PeopleEntity();
            peopleEntity.setEmail(peopleDto.getEmail().trim());
            peopleEntity.setPassword(peopleDto.getPassword().trim());
            peopleEntity.save(peopleEntity);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

    @Override
    public Optional<PeopleEntity> findUserById(Long id) {
        return peopleRepository.findById(id);
    }

    @Override
    public ResponseEntity<PeopleEntity> updatePeople(long id) {
        return null;
    }

    @Override
    public PeopleDto updateByUserId(UserUpdateForm form, Long id) {

        Optional<PeopleEntity> op = peopleRepository.findById(id);
        if (op.isPresent()) {
            PeopleEntity obj = op.get();
            if (form.getPassword() != null) {
                obj.setEmail(form.getEmail());
            }
            if (form.getEmail() != null) {
                obj.setPassword(form.getPassword());
            }
            peopleRepository.save(obj);
            return convertToDto(obj);
        }
        return null;
    }

    // Converter ENTITY to DTO
    private PeopleDto convertToDto(PeopleDto userEntity) {
        PeopleDto dto = new PeopleDto();
        dto.setId(userEntity.getId());
        dto.setEmail(userEntity.getEmail());
        dto.setPassword(userEntity.getPassword());
        return dto;
    }


    public void deleteById(Long id) {
        try {
            if (peopleRepository.existsById(id)) {
                peopleRepository.deleteById(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }{

}
