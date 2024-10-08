package com.practice.ddd.domain.article.model.entity;

import com.practice.ddd.domain.article.model.value.ArticleContent;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "article")
@SecondaryTable(name = "article_content", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @AttributeOverride(name = "content", column = @Column(table = "article_content", name = "content"))
    @AttributeOverride(name = "contentType", column = @Column(table = "article_content", name = "content_type"))
    @Embedded
    private ArticleContent content;

}
