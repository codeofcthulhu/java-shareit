package ru.practicum.shareit.item.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.exception.UnauthorizedAccessException;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.mapper.ItemMapper;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.item.repository.ItemRepository;
import ru.practicum.shareit.request.service.ItemRequestService;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.service.UserService;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserService userService;
    private final ItemRequestService itemRequestService;

    @Override
    public ItemDto create(Long userId, ItemDto itemDto) {
        User user = userService.checkIdAndReturnUser(userId);
        Item item = ItemMapper.toItem(itemDto);
        item.setOwner(user);
        return ItemMapper.toItemDto(itemRepository.create(item));
    }

    @Override
    public ItemDto getById(Long itemId) {
        return ItemMapper.toItemDto(checkIdAndReturnItem(itemId));
    }

    @Override
    public List<ItemDto> getAllByUserId(Long userId) {
        return itemRepository.getAllByUserId(userId).stream().map(ItemMapper::toItemDto).collect(
                Collectors.toList());
    }

    @Override
    public List<ItemDto> getBySearchQuery(String text) {
        return itemRepository.getAll().stream()
                .filter(item -> (item.getName().toLowerCase().contains(text) || item.getDescription().toLowerCase()
                        .contains(text))).map(ItemMapper::toItemDto).collect(Collectors.toList());
    }

    @Override
    public ItemDto patch(Long userId, Long itemId, ItemDto itemDto) {
        if (!itemId.equals(userId)) {
            throw new UnauthorizedAccessException(String.format("User is not an owner of item with id %d", itemId));
        }
        Item item = checkIdAndReturnItem(itemId);
        String name = itemDto.getName();
        String description = itemDto.getDescription();
        Boolean available = itemDto.getAvailable();
        if (name != null) {
            item.setName(name);
        }
        if (description != null) {
            item.setDescription(description);
        }
        if (available != null) {
            item.setAvailable(available);
        }
        return ItemMapper.toItemDto(itemRepository.update(item));
    }

    public Item checkIdAndReturnItem(Long id) {
        Item item = itemRepository.getById(id);
        if (item == null) {
            throw new NotFoundException(String.format("Item with id: %d is not found", id));
        } else {
            return item;
        }
    }
}
