package ru.practicum.shareit.item.repository;

import java.util.List;
import ru.practicum.shareit.item.model.Item;

public interface ItemRepository {

    public Item create(Item item);

    public Item getById(Long id);

    public List<Item> getAllByUserId(Long userId);

    public List<Item> getAll();

    public Item update(Item item);
}
