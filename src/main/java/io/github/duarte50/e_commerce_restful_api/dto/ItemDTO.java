package io.github.duarte50.e_commerce_restful_api.dto;

import io.github.duarte50.e_commerce_restful_api.entity.Category;
import io.github.duarte50.e_commerce_restful_api.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Timestamp lastChange;
    private boolean available;
    private String imagePath;
    private List<String> categories;

    private UUID sellerId;
    private String sellerName;
    private String sellerEmail;
    private String sellerPhoneNumber;
    private String sellerCep;
    private String sellerNeighborhood;
    private String sellerCity;
    private String sellerUf;

    public static ItemDTO map(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .price(item.getPrice())
                .lastChange(item.getLastChange())
                .available(item.isAvailable())
                .imagePath(item.getImagePath())
                .categories(item.getCategories().stream().map(Category::getName).toList())
                .sellerId(item.getSeller().getId())
                .sellerName(item.getSeller().getName())
                .sellerEmail(item.getSeller().getEmail())
                .sellerPhoneNumber(item.getSeller().getPhoneNumber())
                .sellerCep(item.getSeller().getCep())
                .sellerCity(item.getSeller().getCity())
                .sellerUf(item.getSeller().getUf())
                .build();
    }
}
