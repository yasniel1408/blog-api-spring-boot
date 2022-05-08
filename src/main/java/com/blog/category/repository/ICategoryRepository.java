package com.blog.category.repository;

import com.blog.category.dao.CategoryEntityDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntityDao, Integer> {

}
