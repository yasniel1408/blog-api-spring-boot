package com.blog.post.repository;

import com.blog.post.dao.PostEntityDao;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IPostRepository extends JpaRepository<PostEntityDao, Long> {
    /**
     * Exists by title boolean.
     *
     * @param title the title
     * @return the boolean
     */
    boolean existsByTitle(String title);

    /**
     * Exists by title and id is not boolean.
     *
     * @param title the title
     * @param id   the id
     * @return the boolean
     */
    boolean existsByTitleAndIdIsNot(String title, Long id);
}
