package io.github.duarte50.e_commerce_restful_api.controller;

import io.github.duarte50.e_commerce_restful_api.dto.ItemDTO;
import io.github.duarte50.e_commerce_restful_api.service.ItemService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Optional<ItemDTO>> create(
            @RequestBody ItemDTO request,
            @RequestHeader("Authorization") String token
    ) {
        var item = itemService.create(request, token);

        assert item.isPresent();

        return ResponseEntity.created(URI.create("http://localhost:8080/item/" + item.get().getId()))
                .body(item);
    }

    @GetMapping
    public ResponseEntity<Page<ItemDTO>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String category
    ) {
        return ResponseEntity.ok(itemService.readAll(page, name, category));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<ItemDTO>> findById(
            @PathVariable("id") UUID id
    ) {
        return ResponseEntity.ok(itemService.readOneById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ItemDTO>> update(
            @PathVariable UUID id,
            @RequestBody ItemDTO request,
            @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok(itemService.update(id, request, token));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable UUID id,
            @RequestHeader("Authorization") String token
    ) {
        itemService.delete(id, token);
        return ResponseEntity.noContent().build();
    }
}
