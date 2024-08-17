package com.example.studyfirst.service;

import com.example.studyfirst.domain.Member;
import com.example.studyfirst.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getSequence();
    }

    //회원중복검사
    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long memberSequence){
        return memberRepository.findBySequence(memberSequence);
    }

    public void updateMember(Member member) {
        // 기존 회원 정보 가져오기
        Member modifyMember = memberRepository.findById(member.getId()).orElse(null);
        if (modifyMember != null) {
            // 기존 회원 정보 업데이트
            modifyMember.setName(member.getName());
            modifyMember.setAge(member.getAge());
            modifyMember.setAddress(member.getAddress());
            modifyMember.setBlType(member.getBlType());
            modifyMember.setSequence(member.getSequence());
            // 데이터베이스에 업데이트된 회원 정보 저장
            memberRepository.update(modifyMember);
        }
    }


}
