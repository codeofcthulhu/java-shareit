package ru.practicum.shareit.user.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.DuplicatedDataException;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.mapper.UserMapper;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        User user = UserMapper.toUser(userDto);
        checkUniqueEmail(user.getEmail());
        return UserMapper.toUserDto(userRepository.create(user));
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.getAll().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        return UserMapper.toUserDto(checkIdAndReturnUser(id));
    }

    @Override
    public UserDto patch(Long id, UserDto userDto) {
        User user = checkIdAndReturnUser(id);
        String name = userDto.getName();
        String email = userDto.getEmail();
        if (name != null) {
            user.setName(name);
        }
        if (email != null) {
            checkUniqueEmail(email);
            user.setEmail(email);
        }
        return UserMapper.toUserDto(userRepository.update(user));
    }

    @Override
    public void delete(Long id) {
        User user = checkIdAndReturnUser(id);
        userRepository.delete(id);
    }

    public User checkIdAndReturnUser(Long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new NotFoundException(String.format("User with id: %d is not found", id));
        } else {
            return user;
        }
    }

    private void checkUniqueEmail(String email) {
        if (userRepository.getAll().stream()
                .anyMatch(u -> u.getEmail().equals(email))) {
            throw new DuplicatedDataException(String.format("User with email: %s has already existed", email));
        }
    }
}
