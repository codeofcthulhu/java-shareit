package ru.practicum.shareit.user.repository;

import java.util.List;
import ru.practicum.shareit.user.model.User;

public interface UserRepository {

    User create(User user);

    List<User> getAll();

    User getById(Long id);

    User update(User user);

    void delete(Long id);

    boolean emailExist(String email);

}
