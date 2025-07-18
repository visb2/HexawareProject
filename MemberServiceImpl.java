package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	private MemberRepository memberRepo;

	public MemberServiceImpl(MemberRepository memberRepository) {
		super();
		this.memberRepo = memberRepository;
	}

	@Override
	public Member createMember(Member member) {
		return memberRepo.save(member);
	}

	@Override
	public List<Member> getAllMembers() {
		return memberRepo.findAll();
	}

	@Override
	public Member getMemberById(Integer memberId) {
		Optional<Member> memberById = memberRepo.findById(memberId);
		return memberById.get();
	}

	@Override
	public Member updateMember(Member member) {
		Member existingMember = memberRepo.findById(member.getMemberId()).get();
		existingMember.setMemberName(member.getMemberName());
		existingMember.setMemberEmail(member.getMemberEmail());
		existingMember.setMemberPassword(member.getMemberPassword());
		
		Member updatedMemberDetails = memberRepo.save(existingMember);
		return updatedMemberDetails;
	}

	@Override
	public void deleteMember(Integer memberId) {
		memberRepo.deleteById(memberId);
	}
	
}
