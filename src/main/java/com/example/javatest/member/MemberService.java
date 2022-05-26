package com.example.javatest.member;

import com.example.javatest.domain.Member;

public interface MemberService {

    Member findById(Long memberId) throws MemberNotFoundException;
}
