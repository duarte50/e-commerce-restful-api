package io.github.duarte50.e_commerce_restful_api.service.impl;

import io.github.duarte50.e_commerce_restful_api.dto.WishlistDTO;
import io.github.duarte50.e_commerce_restful_api.entity.Wishlist;
import io.github.duarte50.e_commerce_restful_api.repository.ItemRepository;
import io.github.duarte50.e_commerce_restful_api.repository.UserRepository;
import io.github.duarte50.e_commerce_restful_api.repository.WishlistRepository;
import io.github.duarte50.e_commerce_restful_api.service.JWTService;
import io.github.duarte50.e_commerce_restful_api.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final JWTService jwtService;

    @Override
    public Optional<WishlistDTO> create(WishlistDTO request, String token) {
        var userEmail = jwtService.extractUsername(token.substring(7));
        var findItem = itemRepository.findById(request.getItemId());
        var findUser = userRepository.findByEmail(userEmail);

        if (findItem.isEmpty() || findUser.isEmpty()) {
            return Optional.empty();
        }

        var item = findItem.get();
        var user = findUser.get();

        System.out.println(item);

        var wishlist = wishlistRepository.save(Wishlist.map(item, user));

        return Optional.of(WishlistDTO.map(wishlist));
    }

    @Override
    public Page<WishlistDTO> readAll(int page, String token) {
        var userEmail = jwtService.extractUsername(token.substring(7));
        var findUser = userRepository.findByEmail(userEmail);

        if (findUser.isEmpty()) {
            return Page.empty();
        }

        var findWishlist = wishlistRepository.findAllByUserEmailOrderByCreatedDate(
                userEmail, PageRequest.of(Math.max(0, page - 1), 4
        ));

        return findWishlist.map(WishlistDTO::map);
    }

    @Override
    public void delete(UUID itemId, String token) {
        var userEmail = jwtService.extractUsername(token.substring(7));
        var findItem = itemRepository.findById(itemId);
        var findUser = userRepository.findByEmail(userEmail);

        if (findUser.isEmpty() || findItem.isEmpty()) {
            return;
        }

        wishlistRepository.deleteByItemId(itemId);
    }
}
