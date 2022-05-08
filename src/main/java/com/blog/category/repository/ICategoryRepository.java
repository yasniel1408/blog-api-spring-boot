package com.blog.category.repository;

import com.blog.category.dao.CategoryEntityDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntityDao, Long> {
    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Exists by name and id is not boolean.
     *
     * @param name the name
     * @param id   the id
     * @return the boolean
     */
    boolean existsByNameAndIdIsNot(String name, Long id);
}
