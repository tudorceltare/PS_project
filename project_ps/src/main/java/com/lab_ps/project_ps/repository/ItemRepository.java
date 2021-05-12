package com.lab_ps.project_ps.repository;

import com.lab_ps.project_ps.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Item> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
