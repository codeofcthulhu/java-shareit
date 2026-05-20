package ru.practicum.shareit.request.repository;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.request.model.ItemRequest;

@Repository
@RequiredArgsConstructor
public class ItemRequestRepositoryInMemory implements ItemRequestRepository {
    private Long idCounter = 0L;
    private Map<Long, ItemRequest> idToItemRequest = new HashMap<>();

    @Override
    public ItemRequest getById(Long id) {
        return idToItemRequest.get(id);
    }
}
