package ru.practicum.shareit.item.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import ru.practicum.shareit.validation.groups.OnCreate;

@Data
@Builder
public class ItemDto {
    private Long id;
    @NotBlank(groups = OnCreate.class, message = "Item name must not be empty")
    @NotNull(groups = OnCreate.class, message = "Item name must be specified")
    private String name;
    @NotBlank(groups = OnCreate.class, message = "Item description must not be empty")
    @NotNull(groups = OnCreate.class, message = "Item description must be specified")
    private String description;
    @NotNull(groups = OnCreate.class, message = "Item availability status must be specified")
    private Boolean available;
    private Long request;
}
