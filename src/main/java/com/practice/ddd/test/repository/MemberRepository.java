package com.practice.ddd.test.repository;

import com.practice.ddd.test.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {

    Member findById(String id);
}
