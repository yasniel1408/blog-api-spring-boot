package com.blog.category.dao;

import com.blog.common.dao.BaseAnonymousEntityDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntityDao extends BaseAnonymousEntityDao {
    /**
     * Name of Category
     */
    private String name;
}
