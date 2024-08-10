package com.practice.ddd.domain.product.entity;

import com.practice.ddd.domain.article.model.value.Image;
import com.practice.ddd.domain.common.jpa.MoneyConverter;
import com.practice.ddd.domain.product.value.CategoryId;
import com.practice.ddd.domain.product.value.Option;
import com.practice.ddd.domain.product.value.ProductCreationCommand;
import com.practice.ddd.domain.product.value.ProductId;
import com.practice.ddd.test.value.Money;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
  @EmbeddedId private ProductId productId;
  private String name;

  @Convert(converter = MoneyConverter.class)
  private Money price;

  private String detail;

  @OneToMany(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      orphanRemoval = true)
  @JoinColumn(name = "product_id")
  @OrderColumn(name = "list_idx")
  private List<Image> images = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
  private Set<CategoryId> categoryIds;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "product_option", joinColumns = @JoinColumn(name = "product_id"))
  @OrderColumn(name = "list_idx")
  private List<Option> options = new ArrayList<>();

  public static Product getProduct(ProductId id, ProductCreationCommand cmd) {
    return Product.builder().productId(id).price(cmd.getPrice()).detail(cmd.getDetail()).build();
  }

  public void changeImage(List<Image> newImages) {
    images.clear();
    images.addAll(newImages);
  }

  public void removeOptions(int optIdxToBeDeleted) {
    // 실제 컬렉션에 접근할 때 로딩
    this.options.remove(optIdxToBeDeleted);
  }
}
