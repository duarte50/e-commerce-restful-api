package io.github.duarte50.e_commerce_restful_api.repository;

import io.github.duarte50.e_commerce_restful_api.entity.Wishlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, UUID> {
    Page<Wishlist> findAllByUserEmailOrderByCreatedDate(String userEmail, Pageable pageable);
    void deleteByItemId(UUID itemId);
}
