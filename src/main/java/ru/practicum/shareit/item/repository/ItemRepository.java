package ru.practicum.shareit.item.repository;

import java.util.List;
import ru.practicum.shareit.item.model.Item;

public interface ItemRepository {

    Item create(Item item);

    Item getById(Long id);

    List<Item> getAllByUserId(Long userId);

    List<Item> getAll();

    Item update(Item item);
}
