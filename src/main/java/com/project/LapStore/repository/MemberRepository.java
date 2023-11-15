package com.project.LapStore.repository;

import com.project.LapStore.domain.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    Member findOne(Long id);

    List<Member> findAll();

    List<Member> findByName(String name);

    Long getSize();
}
