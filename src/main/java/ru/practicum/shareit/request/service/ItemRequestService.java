package ru.practicum.shareit.request.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.request.model.ItemRequest;
import ru.practicum.shareit.request.repository.ItemRequestRepository;

@Service
@RequiredArgsConstructor
public class ItemRequestService {

    private ItemRequestRepository itemRequestRepository;

    public ItemRequest checkIdAndReturnItemRequest(Long id) {
        ItemRequest itemRequest = itemRequestRepository.getById(id);
        if (itemRequest == null) {
            throw new NotFoundException(String.format("ItemRequest with id: %d is not found", id));
        } else {
            return itemRequest;
        }
    }

}
