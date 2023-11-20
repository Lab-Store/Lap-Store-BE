package com.project.LapStore.repository;

import com.project.LapStore.domain.Item;
import com.project.LapStore.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
