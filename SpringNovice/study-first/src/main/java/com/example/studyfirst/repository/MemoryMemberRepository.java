package com.example.studyfirst.repository;

import com.example.studyfirst.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    public static Long sequence = 0L;
    private static Map<Long,Member> store = new HashMap<>();
    @Override
    public Member save(Member member) {
        member.setSequence(++sequence);
        store.put(member.getSequence(), member);
        return member;
    }

    public Member update(Member member) {
        member.setSequence(sequence);
        store.put(member.getSequence(), member);
        return member;
    }


    @Override
    public Optional<Member> findBySequence(Long sequence) {
        Member member = store.get(sequence);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public Optional<Member> findById(String id) {
        return store.values().stream().filter(member -> member.getId().equals(id)).findAny();
    }

    @Override
    public Optional<Member> findByPassword(String password) {
        return store.values().stream().filter(member -> member.getId().equals(password)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
