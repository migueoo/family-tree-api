package api.familytree.dto;

import lombok.Data;

@Data
public class UserUpdateForm {
    private String email;

    private String password;
}
