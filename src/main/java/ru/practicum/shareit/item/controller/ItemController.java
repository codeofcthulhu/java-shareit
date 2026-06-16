package ru.practicum.shareit.item.controller;

import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.service.ItemService;
import ru.practicum.shareit.validation.groups.OnCreate;

@RestController
@RequestMapping("/items")
@Validated
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private static final String USER_ID_HEADER = "X-Sharer-User-Id";

    @PostMapping
    public ItemDto create(@RequestHeader(USER_ID_HEADER) @Positive Long userId,
            @Validated(OnCreate.class) @RequestBody ItemDto itemDto) {
        return itemService.create(userId, itemDto);
    }

    @GetMapping("/{itemId}")
    public ItemDto getById(@PathVariable @Positive Long itemId) {
        return itemService.getById(itemId);
    }

    @GetMapping
    public List<ItemDto> getAllByUserId(@RequestHeader(USER_ID_HEADER) @Positive Long userId) {
        return itemService.getAllByUserId(userId);
    }

    @GetMapping("/search")
    public List<ItemDto> getBySearchQuery(@RequestParam("text") String text) {
        return itemService.getBySearchQuery(text);
    }

    @PatchMapping("/{itemId}")
    public ItemDto patch(@PathVariable @Positive Long itemId, @RequestHeader(USER_ID_HEADER) @Positive Long userId,
            @RequestBody ItemDto itemDto) {
        return itemService.patch(itemId, userId, itemDto);
    }

}
