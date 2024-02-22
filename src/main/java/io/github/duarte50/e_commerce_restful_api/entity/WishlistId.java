package io.github.duarte50.e_commerce_restful_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishlistId {
    private Item item;
    private User user;
}
