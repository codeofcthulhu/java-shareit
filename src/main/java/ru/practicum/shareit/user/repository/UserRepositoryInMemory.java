package ru.practicum.shareit.user.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.shareit.user.model.User;

@Repository
@RequiredArgsConstructor
public class UserRepositoryInMemory implements UserRepository {
    private Long idCounter = 0L;
    private Map<Long, User> idToUser = new HashMap<>();

    @Override
    public User create(User user) {
        user.setId(++idCounter);
        idToUser.put(idCounter, user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(idToUser.values());
    }

    @Override
    public User getById(Long id) {
        return idToUser.get(id);
    }

    @Override
    public User update(User user) {
        idToUser.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(Long id) {
        idToUser.remove(id);
    }
}
