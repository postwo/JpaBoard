package com.example.JpaBoard.repository.querydsl;

import com.example.JpaBoard.domain.Article;
import com.example.JpaBoard.domain.QArticle;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {

    public ArticleRepositoryCustomImpl() {
        super(Article.class);  // 1.부모 클래스인 QuerydslRepositorySupport에 Article 클래스를 전달하는 것 //2. 이 구현체가 Article 엔티티와 관련된 일을 할 거야"라고 부모 클래스에게 알려주는 역할
    }

    @Override
    public List<String> findAllDistinctHashtags() {

        QArticle article = QArticle.article;

        return from(article)
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull())
                .fetch();
    }
}