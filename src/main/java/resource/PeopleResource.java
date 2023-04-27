package resource;

import api.familytree.dto.PeopleDto;
import api.familytree.entity.PeopleEntity;
import api.familytree.repository.PeopleRepository;
import api.familytree.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PeopleResource {

    private final PeopleService peopleService;

    private final PeopleRepository peopleRepository;

    public PeopleResource(PeopleService peopleService, PeopleRepository peopleRepository) {
        this.peopleService = peopleService;
        this.peopleRepository = peopleRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody PeopleDto peopleDto) {
        peopleService.salvar(peopleDto);
    }


    @GetMapping
    public List<PeopleEntity> list() {
        return peopleRepository.findAll();
    }


    @GetMapping("/{id}")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Optional<PeopleEntity> findById(@PathVariable Long id) {
        return peopleService.findUserById(id);
    }


    @PutMapping("/{id}")
    public PeopleDto updateById(@RequestBody UserUpdateForm form, @PathVariable("id") Long id) {
        return peopleService.updateByUserId(form, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        peopleService.deleteById(id);
    }

}
