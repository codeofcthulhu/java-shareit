package ru.practicum.shareit.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import ru.practicum.shareit.validation.groups.OnCreate;
import ru.practicum.shareit.validation.groups.OnPatch;

@Data
@Builder
public class UserDto {

    private Long id;
    @NotBlank(groups = OnCreate.class, message = "User's name must be specified")
    private String name;
    @NotBlank(groups = OnCreate.class, message = "Email must not be blank")
    @Email(groups = {OnCreate.class, OnPatch.class}, message = "Email is invalid")
    private String email;
}
