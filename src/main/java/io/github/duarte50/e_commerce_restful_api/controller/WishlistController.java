package io.github.duarte50.e_commerce_restful_api.controller;

import io.github.duarte50.e_commerce_restful_api.dto.WishlistDTO;
import io.github.duarte50.e_commerce_restful_api.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistService wishlistService;

    @PostMapping
    public ResponseEntity<Optional<WishlistDTO>> create(
            @RequestBody WishlistDTO request,
            @RequestHeader("Authorization") String token
    ) {
        var wishlist = wishlistService.create(request, token);

        assert wishlist.isPresent();

        return ResponseEntity.created(URI.create("http://localhost:8080/wishlist"))
                .body(wishlist);
    }

    @GetMapping
    public ResponseEntity<Page<WishlistDTO>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok(wishlistService.readAll(page, token));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable UUID id,
            @RequestHeader("Authorization") String token
    ) {
        wishlistService.delete(id, token);
        return ResponseEntity.noContent().build();
    }
}
