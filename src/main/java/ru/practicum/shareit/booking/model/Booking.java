package ru.practicum.shareit.booking.model;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

@Data
@Builder
public class Booking {
    private Long id;
    private Instant start;
    private Instant end;
    private Item item;
    private User booker;
    private Status status;

}
