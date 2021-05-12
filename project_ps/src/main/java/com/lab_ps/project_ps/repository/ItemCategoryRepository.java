package com.lab_ps.project_ps.repository;

import com.lab_ps.project_ps.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "itemCategory", path = "item-category")
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
}
