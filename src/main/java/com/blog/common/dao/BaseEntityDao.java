package com.blog.common.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * <code>BaseEntity</code> class is the parent class for all the database entities in the dao-customer-attribute module.
 * All the common attributes are consolidated in this entity.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntityDao extends BaseAnonymousEntityDao {

    /**
     * Created By
     */
    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    /**
     * Last Modified By
     */
    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

}
