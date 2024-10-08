package com.practice.ddd.domain.member.domain;

import com.practice.ddd.domain.member.domain.value.MemberGrade;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
  private String memberNo;
  private String password;
  private MemberGrade memberGrade;

  public void changePassword(String oldPw, String newPw) {
    if (!matchPassword(oldPw)) throw new IllegalArgumentException();
    setPassword(newPw);
  }

  private void setPassword(String newPw) {
    this.password = newPw;
  }

  public boolean matchPassword(String oldPw) {
    return this.password.equals(oldPw);
  }
}
