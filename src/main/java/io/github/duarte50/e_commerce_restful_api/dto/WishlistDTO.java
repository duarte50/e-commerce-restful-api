package io.github.duarte50.e_commerce_restful_api.dto;

import io.github.duarte50.e_commerce_restful_api.entity.Category;
import io.github.duarte50.e_commerce_restful_api.entity.Wishlist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishlistDTO {
    private UUID itemId;
    private String itemName;
    private String itemImagePath;
    private List<String> categories;

    private UUID userId;
    private String userEmail;

    public static WishlistDTO map(Wishlist wishlist) {
        return WishlistDTO.builder()
                .itemId(wishlist.getItem().getId())
                .itemName(wishlist.getItem().getName())
                .itemImagePath(wishlist.getItem().getImagePath())
                .categories(wishlist.getItem().getCategories().stream().map(Category::getName).toList())
                .userId(wishlist.getUser().getId())
                .userEmail(wishlist.getUser().getEmail())
                .build();
    }
}
