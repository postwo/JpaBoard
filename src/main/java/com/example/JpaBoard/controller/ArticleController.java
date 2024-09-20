package com.example.JpaBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
}
