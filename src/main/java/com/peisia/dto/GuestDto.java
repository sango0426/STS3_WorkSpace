package com.peisia.dto;

import lombok.Data;

@Data
public class GuestDto {
	// 테이블명 상수 선언
	public final static String TABLE_NAME_GUEST = "tbl_guest";

	// 게시물 번호
	private Long bno;

	// 게시물 제목
	private String btitle;

	// 게시물 내용
	private String btext;
}