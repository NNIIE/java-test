package com.example.javatest.study;

import com.example.javatest.domain.Member;
import com.example.javatest.domain.Study;
import com.example.javatest.member.MemberService;

public class StudyService {

    private final MemberService memberService;

    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {
        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Member member = memberService.findById(memberId);
        if (member == null)
            throw new IllegalArgumentException("");
        study.setOwner(member);

        return repository.save(study);
    }
}
