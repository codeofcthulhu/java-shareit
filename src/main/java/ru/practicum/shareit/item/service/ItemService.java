package ru.practicum.shareit.item.service;

import java.util.List;
import ru.practicum.shareit.item.dto.ItemDto;

public interface ItemService {

    public ItemDto create(Long userId, ItemDto itemDto);

    public ItemDto getById(Long itemId);

    public List<ItemDto> getAllByUserId(Long userId);

    public List<ItemDto> getBySearchQuery(String text);

    public ItemDto patch(Long itemId, Long userId, ItemDto itemDto);

}
