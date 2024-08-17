package com.example.studyfirst.repository;

import com.example.studyfirst.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    Member save(Member member);
    Member update(Member member);
    Optional<Member> findBySequence(Long sequence);
    Optional<Member> findByName(String name);
    Optional<Member> findById(String id);
    Optional<Member> findByPassword(String password);
    List<Member> findAll();
    void clearStore();
}
