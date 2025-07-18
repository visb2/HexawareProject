package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@RestController
@RequestMapping("api/member")
public class MemberController {
	private  MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@PostMapping
	public ResponseEntity<Member> createMember(@RequestBody Member member) {
	    Member savedMember = memberService.createMember(member);
	    return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
	}
	
	@GetMapping("/{memberId}")
	public ResponseEntity<Member> getMemberById(@PathVariable("memberId") Integer memberId) {
	    Member member = memberService.getMemberById(memberId);
	    return new ResponseEntity<>(member, HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<Member>> getAllMember() {
        List<Member> memberList = memberService.getAllMembers();
        return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
    }
	
	@PutMapping("/{memberId}")
	public ResponseEntity<Member> updateMember(@PathVariable Integer memberId, @RequestBody Member member) {
		member.setMemberId(memberId);
		Member updatedMember = memberService.updateMember(member);
		
		return new ResponseEntity<Member>(updatedMember, HttpStatus.OK);
	}
	
	@DeleteMapping("/{memberId}")
	public void deleteBook(@PathVariable("memberId") Integer memberId) {
	    memberService.deleteMember(memberId);
	}
}
