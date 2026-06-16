package ru.practicum.shareit.user.service;

import java.util.List;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;

public interface UserService {

    UserDto create(UserDto userDto);

    List<UserDto> getAll();

    UserDto getById(Long id);

    UserDto patch(Long id, UserDto user);

    void delete(Long id);

    User getUserOrThrow(Long id);
}
