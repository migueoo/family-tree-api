package api.familytree.dto;

import api.familytree.entity.PeopleEntity;

public class PeopleDto {

    private long id;
    private String email;
    private String password;

    public PeopleDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public PeopleDto(PeopleEntity peopleEntity) {
    }

    public PeopleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

