package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Member;

public interface MemberService {
	Member createMember(Member member);
	List<Member> getAllMembers(); 
	Member getMemberById(Integer memberId); 
	Member updateMember(Member member); 
	void deleteMember(Integer memberId); 
}
