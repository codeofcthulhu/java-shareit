package ru.practicum.shareit.user.service;

import java.util.List;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;

public interface UserService {
    public UserDto create(UserDto userDto);
    public List<UserDto> getAll();
    public UserDto getById(Long id);
    public UserDto patch(Long id, UserDto user);
    public void delete(Long id);
    public User checkIdAndReturnUser(Long id);
}
