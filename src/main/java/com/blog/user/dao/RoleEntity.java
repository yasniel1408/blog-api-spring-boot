package com.blog.user.dao;

import com.blog.common.dao.BaseEntityDao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

/**
 * {@link RoleEntity} class represents the domain of the role table.
 */
@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity extends BaseEntityDao {

    @Column(name = "name")
    @NaturalId
    private String name;

    @Column(name = "description")
    @NaturalId
    private String description;

    @ManyToMany(mappedBy = "roleEntities")
    private Set<UserEntity> userEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        RoleEntity that = (RoleEntity) o;

        if (!Objects.equals(name, that.name)) {
            return false;
        }
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + (Objects.hashCode(description));
        return result;
    }
}
