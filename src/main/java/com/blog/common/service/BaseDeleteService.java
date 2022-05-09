package com.blog.common.service;

/**
 * The type Base delete service.
 */
public abstract class BaseDeleteService extends BaseService {

    /**
     * Delete.
     *
     * @param id the Id
     */
    public void delete(Long id) {
        executeDelete(id);
    }

    /**
     * Execute delete.
     *
     * @param id the Id
     */
    protected abstract void executeDelete(Long id);

}
