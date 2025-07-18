package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Members")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberId;
	private String memberName;
	@Column(nullable=false)
	private String memberEmail;
	@Column(nullable=false)
	private String memberPassword;
	
	public Member(int memberId, String memberName, String memberEmail, String memberPassword) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
	}

	public Member() {
		super();
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	
	
}
