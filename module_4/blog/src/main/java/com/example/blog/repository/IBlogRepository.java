package com.example.blog.repository;

import com.example.blog.entity.Blog;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @NonNull
    Page<Blog> findAll(@NonNull Pageable pageable);
    Page<Blog> findByTitleContaining(String keyword, Pageable pageable);

    Page<Blog> findByCategoryId(int categoryId, Pageable pageable);

    Page<Blog> findByTitleContainingAndCategoryId(String keyword, int categoryId, Pageable pageable);
}
