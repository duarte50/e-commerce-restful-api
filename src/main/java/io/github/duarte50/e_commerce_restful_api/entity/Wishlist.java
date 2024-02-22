package io.github.duarte50.e_commerce_restful_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@IdClass(WishlistId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wishlist {
    @Id @ManyToOne @JoinColumn(nullable = false)
    private Item item;
    @Id @ManyToOne @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private Timestamp createdDate;

    public static Wishlist map (Item item, User user) {
        return Wishlist.builder()
                .item(item)
                .user(user)
                .createdDate(Timestamp.from(Instant.now()))
                .build();
    }
}
