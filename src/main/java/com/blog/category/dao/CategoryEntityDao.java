package com.blog.category.dao;

import com.blog.common.dao.BaseAnonymousEntityDao;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Data
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryEntityDao extends BaseAnonymousEntityDao {
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    private String description;
}
