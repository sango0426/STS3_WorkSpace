package com.peisia.service;

import java.util.HashMap;
import java.util.List;
import com.peisia.dto.GuestDto;
import com.peisia.dto.PagingDto;

public interface GuestService {

	// 특정 페이지에 해당하는 게시물 리스트를 가져오는 메서드
	public List<GuestDto> getList(int page);

	// 특정 게시물을 읽어오는 메서드
	public GuestDto read(long bno);

	// 특정 게시물을 삭제하는 메서드
	public void del(long bno);

	// 새로운 게시물을 작성하는 메서드
	public void write(GuestDto dto);

	// 게시물을 수정하는 메서드
	public void modify(GuestDto dto);

	// 특정 페이지에 해당하는 게시물 목록을 가져오기 위해 필요한 시작 인덱스를 계산하는 메서드
	public int getStartIndex(int page);

	// 전체 게시물 수를 가져오는 메서드
	public int getTotalCount();

	// 전체 페이지 수를 계산하는 메서드
	public int getTotalPage();

	// 전체 블록 수를 계산하는 메서드
	public int getTotalBlock(int totalPage);
}