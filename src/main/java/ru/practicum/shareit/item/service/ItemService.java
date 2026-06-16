package ru.practicum.shareit.item.service;

import java.util.List;
import ru.practicum.shareit.item.dto.ItemDto;

public interface ItemService {

    ItemDto create(Long userId, ItemDto itemDto);

    ItemDto getById(Long itemId);

    List<ItemDto> getAllByUserId(Long userId);

    List<ItemDto> getBySearchQuery(String text);

    ItemDto patch(Long itemId, Long userId, ItemDto itemDto);

}
