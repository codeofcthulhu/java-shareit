package ru.practicum.shareit.item.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.shareit.item.model.Item;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryInMemory implements ItemRepository {

    private Long idCounter = 0L;
    private Map<Long, Item> idToItem = new HashMap<>();

    @Override
    public Item create(Item item) {
        item.setId(++idCounter);
        idToItem.put(idCounter, item);
        return item;
    }

    @Override
    public Item update(Item item) {
        idToItem.put(item.getId(), item);
        return item;
    }

    public Item getById(Long id) {
        return idToItem.get(id);
    }

    public List<Item> getAllByUserId(Long userId) {
        return idToItem.values().stream().filter(item -> item.getOwner().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Item> getAll() {
        return new ArrayList<>(idToItem.values());
    }

}
