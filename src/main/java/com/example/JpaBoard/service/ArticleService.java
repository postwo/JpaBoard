package com.example.JpaBoard.service;

import com.example.JpaBoard.domain.type.SearchType;
import com.example.JpaBoard.dto.ArticleDto;
import com.example.JpaBoard.dto.ArticleUpdateDto;
import com.example.JpaBoard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional //클래스 레벨로 건다
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    //변경하는게 없어서 읽기만 할거라서 read를 걸어준다
    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String search_keyword) {
        // 유효성 검사 추가
        if (search_keyword == null || search_keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("검색 키워드는 공백이나 null이 될 수 없습니다.");
        }

        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(long articleId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
