package com.example.JpaBoard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mvc;

//    @Autowired  //생성자가 하나일 경우 일반 클래스에서는 생략할 수 있지만, 테스트 클래스에서는 일반적으로 생략하지 않는 것이 안전하다
    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


    //media type 검사에서 부가적인 옵션이 들어갈 수 있음을 확인했기 때문에 contentType대신 contentTypeCompatibleWith으로 변경해서 호환되는 타입까지 맞다고 하게 해준다
    // charset == utf8이 옵션을 붙어도 동작테스트 할수 있게 contentType대신 contentTypeCompatibleWith으로 변경해준다
    @DisplayName("[view][GET] 게시글 리스트 (게시판) 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {
        // Given
        // When & Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk()) //status ok인지 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //content 내용의 타입이 뷰니까 TEXT_HTML인지 확인 //contentTypeCompatibleWith은 호환되는 타입까지 맞다고 해준다
                .andExpect(view().name("articles/index"))//뷰 이름에대해 테스트 있는지 확인
                .andExpect(model().attributeExists("articles")); //articles이 이름의 키가있는지 또는 데이터가 있는지 확인
    }

    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 상세 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception {
        // Given
        // When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments")); //댓글(1개 or 여러개)도 추가

    }

    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception {
        // Given
        // When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search")); //게시글

    }

    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnsArticleHashtagSearchView() throws Exception {
        // Given
        // When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag")); //해시태그

    }
}