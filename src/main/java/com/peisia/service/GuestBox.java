package com.peisia.service;

import java.util.List;
import com.peisia.dto.GuestDto;
import lombok.Data;

@Data
public class GuestBox {
	// 게시물 목록을 담는 리스트
	private List<GuestDto> posts;

	// 게시물 총 개수
	private int count;
}