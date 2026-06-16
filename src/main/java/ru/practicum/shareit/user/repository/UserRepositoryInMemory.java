package ru.practicum.shareit.user.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.shareit.user.model.User;

@Repository
@RequiredArgsConstructor
public class UserRepositoryInMemory implements UserRepository {

    private Long idCounter = 0L;
    private Map<Long, User> idToUser = new HashMap<>();
    private Set<String> emailSet = new HashSet<>();

    @Override
    public User create(User user) {
        user.setId(++idCounter);
        idToUser.put(idCounter, user);
        emailSet.add(user.getEmail());
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
        emailSet.remove(idToUser.get(user.getId()).getEmail());
        emailSet.add(user.getEmail());
        idToUser.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(Long id) {
        emailSet.remove(idToUser.get(id).getEmail());
        idToUser.remove(id);
    }

    @Override
    public boolean emailExist(String email) {
        return emailSet.contains(email);
    }
}
