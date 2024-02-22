package io.github.duarte50.e_commerce_restful_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Rating {
    @Id @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private int stars;
    private String message;

    @ManyToOne
    private User seller;
    @ManyToOne
    private User buyer;
}
