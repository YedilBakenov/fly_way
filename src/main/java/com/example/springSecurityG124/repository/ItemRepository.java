package com.example.springSecurityG124.repository;

import com.example.springSecurityG124.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
