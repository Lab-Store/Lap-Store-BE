package com.project.LapStore.repository;

import com.project.LapStore.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Primary
@RequiredArgsConstructor
public class MemberLocalRepository implements MemberRepository{

    private final List<Member> memberList = new ArrayList<>();

    @Override
    public void save(Member member) {
        memberList.add(member);
    }

    @Override
    public Member findOne(Long id) {
        return memberList.get(Math.toIntExact(id - 1));
    }

    @Override
    public List<Member> findAll() {
        return memberList;
    }

    @Override
    public List<Member> findByName(String name) {

        return memberList.stream()
                .filter(member -> member.getName().equals(name))
                .map(Member::new) // 또는 member -> new Member(member)로 변경 가능
                .collect(Collectors.toList());
    }

    @Override
    public Long getSize() {
        return (long) memberList.size();
    }
}
