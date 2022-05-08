package com.blog.category.dao;

import com.blog.common.dao.BaseAnonymousEntityDao;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

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
    @NaturalId
    private String name;
}
