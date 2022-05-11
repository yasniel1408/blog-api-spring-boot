package com.blog.common.service;

import com.blog.common.dao.BaseAnonymousEntityDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The type Base delete service.
 */
public abstract class BaseDeleteService<E extends BaseAnonymousEntityDao,R extends JpaRepository<E, Long>> extends BaseService {

    /**
     * Delete.
     *
     * @param id the Id
     */
    public void delete(Long id) {

        logger.entry(id);

        executeDelete(id);

        logger.exit();
    }

    /**
     * Execute delete.
     *
     * @param id the Id
     */
    protected abstract void executeDelete(Long id);

}
