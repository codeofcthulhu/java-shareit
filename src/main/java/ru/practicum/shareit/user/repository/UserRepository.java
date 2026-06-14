package ru.practicum.shareit.user.repository;

import java.util.List;
import ru.practicum.shareit.user.model.User;

public interface UserRepository {

    public User create(User user);

    public List<User> getAll();

    public User getById(Long id);

    public User update(User user);

    public void delete(Long id);

}
