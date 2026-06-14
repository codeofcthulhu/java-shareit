package ru.practicum.shareit.booking.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import ru.practicum.shareit.item.model.Item;

@Data
@Builder
public class BookingDto {

    private Instant start;
    private Instant end;
    private Item item;
}
