package com.example.JpaBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/articles")
@Controller
public class ArticleController {

    @GetMapping
    public String articles(ModelMap map) { // ModelMap = 컨트롤러에서 데이터를 전달하기 위한 객체로, 뷰(HTML 페이지 등)로 데이터를 넘길 때 사용
        map.addAttribute("articles", List.of()); //List.of()는 빈 리스트를 반환
        return "articles/index";
    }

    //상세 페이지 조회
    //@PathVariable에 파라미터 이름을 명시적으로 추가
    @GetMapping("/{articleId}")
    public String article(@PathVariable("articleId") Long articleId, ModelMap map) {
        map.addAttribute("article", "article"); // TODO: 구현할 때 여기에 실제 데이터를 넣어줘야 한다
        map.addAttribute("articleComments", List.of()); //List.of()는 빈 리스트를 반환
        return "articles/detail";
    }
}
