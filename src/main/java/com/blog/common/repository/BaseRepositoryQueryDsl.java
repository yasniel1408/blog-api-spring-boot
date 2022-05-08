package com.blog.common.repository;


import com.blog.common.dao.BaseAnonymousEntityDao;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * {@link BaseRepositoryQueryDsl} is the base repository to handle queries with query dsl
 *
 * @param <E> the type parameter
 * @param <Q> the type parameter
 */
@NoRepositoryBean
public interface BaseRepositoryQueryDsl<E extends BaseAnonymousEntityDao, Q extends EntityPathBase<E>> extends JpaRepository<E, Long>, QuerydslPredicateExecutor<E>, QuerydslBinderCustomizer<Q> {

    @Override
    default void customize(QuerydslBindings bindings, Q qEntity) {

        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}

