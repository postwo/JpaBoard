package com.example.JpaBoard.service;

import com.example.JpaBoard.domain.type.SearchType;
import com.example.JpaBoard.dto.ArticleDto;
import com.example.JpaBoard.dto.ArticleWithCommentsDto;
import com.example.JpaBoard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional //클래스 레벨로 건다
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    //변경하는게 없어서 읽기만 할거라서 read를 걸어준다
    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(ArticleDto dto) {
    }

    public void deleteArticle(long articleId) {
    }

}
