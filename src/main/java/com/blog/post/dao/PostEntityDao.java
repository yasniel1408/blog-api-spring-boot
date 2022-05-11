package com.blog.post.dao;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.common.dao.BaseEntityDao;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntityDao extends BaseEntityDao {

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntityDao category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoryEntityDao that = (CategoryEntityDao) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
