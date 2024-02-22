package io.github.duarte50.e_commerce_restful_api.repository;

import io.github.duarte50.e_commerce_restful_api.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    Page<Item> findAllByNameContainingAndCategories_NameContainingAllIgnoreCaseOrderByLastChangeDesc(String name, String categoryName, Pageable pageable);
}
