package com.practice.ddd.domain.article.model.value;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@Table(name = "article_content")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ArticleContent {
  private String content;
  private String contentType;
}
