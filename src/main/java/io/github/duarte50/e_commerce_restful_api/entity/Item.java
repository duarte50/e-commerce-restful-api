package io.github.duarte50.e_commerce_restful_api.entity;

import io.github.duarte50.e_commerce_restful_api.dto.ItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Item {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private Timestamp lastChange;
    @Column(nullable = false)
    private boolean available;

    private String imagePath;

    @ManyToMany
    private Set<Category> categories;

    @ManyToOne @JoinColumn(nullable = false)
    private User seller;
    @ManyToOne
    private User buyer;

    public static Item map(ItemDTO itemDTO, Set<Category> categories, User seller, User buyer) {
        return Item.builder()
                .name(itemDTO.getName())
                .description(itemDTO.getDescription())
                .price(itemDTO.getPrice())
                .lastChange(Timestamp.from(Instant.now()))
                .available(itemDTO.isAvailable())
                .imagePath(itemDTO.getImagePath())
                .categories(categories)
                .seller(seller)
                .buyer(buyer)
                .build();
    }

    public static Item map(UUID id, ItemDTO itemDTO, Set<Category> categories, User seller, User buyer) {
        return Item.builder()
                .id(id)
                .name(itemDTO.getName())
                .description(itemDTO.getDescription())
                .price(itemDTO.getPrice())
                .lastChange(Timestamp.from(Instant.now()))
                .available(itemDTO.isAvailable())
                .imagePath(itemDTO.getImagePath())
                .categories(categories)
                .seller(seller)
                .buyer(buyer)
                .build();
    }
}
