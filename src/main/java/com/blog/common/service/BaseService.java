package com.blog.common.service;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

/**
 * The type Base service.
 */
public abstract class BaseService {
    /**
     * The Logger.
     */
    protected final XLogger logger = XLoggerFactory.getXLogger(getClass());
}
