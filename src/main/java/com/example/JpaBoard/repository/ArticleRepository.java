package com.example.JpaBoard.repository;

import com.example.JpaBoard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
