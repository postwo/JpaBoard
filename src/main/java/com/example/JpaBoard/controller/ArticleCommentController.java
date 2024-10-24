package com.example.JpaBoard.controller;

import com.example.JpaBoard.dto.UserAccountDto;
import com.example.JpaBoard.dto.request.ArticleCommentRequest;
import com.example.JpaBoard.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest) {
        // TODO: 인증 정보를 넣어줘야 한다.
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(UserAccountDto.of(
                "uno", "pw", "uno@mail.com", null, null
        )));
        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping ("/{commentId}/delete")
    public String deleteArticleComment(@PathVariable("commentId") Long commentId, @RequestParam("articleId") Long articleId) {
        articleCommentService.deleteArticleComment(commentId);
        return "redirect:/articles/" + articleId;
    }
}
