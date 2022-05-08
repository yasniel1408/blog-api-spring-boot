package com.blog.common.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseAnonymousEntityDao {

    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // SQLite = "AUTO", OTROS = "IDENTITY"
    private Long id;

    /**
     * Created Date
     */
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    /**
     * Last Modified Date
     */
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    /**
     * Version
     */
    @Version
    @Column(name = "version")
    private Long version;

}
