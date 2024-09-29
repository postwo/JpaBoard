package com.example.JpaBoard.service;

import com.example.JpaBoard.domain.Article;
import com.example.JpaBoard.domain.type.SearchType;
import com.example.JpaBoard.dto.ArticleDto;
import com.example.JpaBoard.dto.ArticleUpdateDto;
import com.example.JpaBoard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;




@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        // Given
        // When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");
        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("검색 키워드가 null이면, 예외를 던진다.")
    @Test
    void givenNullSearchKeyword_whenSearchingArticles_thenThrowsException() {
        // Given
        String searchKeyword = null; // null 키워드

        // When & Then
        assertThatThrownBy(() -> sut.searchArticles(SearchType.TITLE, searchKeyword))
                .isInstanceOf(IllegalArgumentException.class) // 예외 타입이 IllegalArgumentException일 것으로 기대
                .hasMessageContaining("검색 키워드는 공백이나 null이 될 수 없습니다."); // 예외 메시지가 포함될 것으로 기대
    }


    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        // Given
        // When
        ArticleDto articles = sut.searchArticle(1L);
        // Then
        assertThat(articles).isNotNull();
    }


    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        // When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "Uno", "title", "content", "#java"));
        // Then
        then(articleRepository).should().save(any(Article.class)); //save를 한 번 호출 했는가를 검사
    }


    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        // When
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));
        // Then
        then(articleRepository).should().save(any(Article.class));
    }


    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // Given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        // When
        sut.deleteArticle(1L);
        // Then
        then(articleRepository).should().delete(any(Article.class));
    }
}