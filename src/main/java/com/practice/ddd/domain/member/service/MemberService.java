package com.practice.ddd.domain.member.service;

import com.practice.ddd.domain.member.domain.Member;
import com.practice.ddd.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  public void changePassword(String memberId, String oldPw, String newPw) {
    Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
    member.changePassword(oldPw, newPw);
  }
}
