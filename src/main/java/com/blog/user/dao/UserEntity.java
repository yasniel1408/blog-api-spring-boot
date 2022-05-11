package com.blog.user.dao;

import com.blog.common.dao.BaseAnonymousEntityDao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * {@link UserEntity} class represents the domain of the app_user table.
 */
@Entity
@Table(name = "app_user")
@Getter
@Setter
public class UserEntity extends BaseAnonymousEntityDao {

    @Column(name = "email")
    @NaturalId
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    /**
     * If it is true, the user has already paid for at least one training
     */
    @Column(name = "bought_trainings")
    private boolean boughtTrainings;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))
    private Set<RoleEntity> roleEntities;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
//    private List<UserTrainingEntity> userTrainingEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        UserEntity that = (UserEntity) o;

        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
