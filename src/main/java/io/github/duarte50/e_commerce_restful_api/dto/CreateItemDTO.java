package io.github.duarte50.e_commerce_restful_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private boolean available;
    private String imagePath;
}
