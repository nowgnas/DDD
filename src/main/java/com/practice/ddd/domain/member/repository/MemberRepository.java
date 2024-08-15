package com.practice.ddd.domain.member.repository;

import com.practice.ddd.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {}
