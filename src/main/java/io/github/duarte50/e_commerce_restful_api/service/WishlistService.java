package io.github.duarte50.e_commerce_restful_api.service;

import io.github.duarte50.e_commerce_restful_api.dto.WishlistDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface WishlistService {
    Optional<WishlistDTO> create(WishlistDTO request, String token);
    Page<WishlistDTO> readAll(int page, String token);
    void delete(UUID itemId, String token);
}
