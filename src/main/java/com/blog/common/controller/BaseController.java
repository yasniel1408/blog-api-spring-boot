package com.blog.common.controller;

import com.blog.common.controller.helpers.ResponseEntityReadMonoCreator;
import com.blog.common.service.BaseService;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Base controller.
 *
 * @param <S> the type parameter
 */
public abstract class BaseController<S extends BaseService> {

    /**
     * The Logger.
     */
    protected final XLogger logger = XLoggerFactory.getXLogger(getClass());

    /**
     * The Service.
     */
    @Autowired
    protected S service;

    @Autowired
    protected ResponseEntityReadMonoCreator responseEntityReadMonoCreator;

}
