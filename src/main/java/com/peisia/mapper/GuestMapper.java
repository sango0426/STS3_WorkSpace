package com.peisia.mapper;

import java.util.List;
import com.peisia.dto.GuestDto;

public interface GuestMapper {

	// 게시물 리스트를 가져오는 메서드
	// limitIndex: 가져올 게시물의 시작 인덱스
	public List<GuestDto> getList(int limitIndex);

	// 전체 게시물 수를 반환하는 메서드
	public int getTotalCount();

	// 특정 게시물을 읽어오는 메서드
	// bno: 게시물 번호
	public GuestDto read(long bno);

	// 특정 게시물을 삭제하는 메서드
	// bno: 삭제할 게시물 번호
	public void del(long bno);

	// 새로운 게시물을 작성하는 메서드
	// dto: 작성할 게시물의 정보를 담은 GuestDto 객체
	public void write(GuestDto dto);

	// 게시물을 수정하는 메서드
	// dto: 수정할 게시물의 정보를 담은 GuestDto 객체
	public void modify(GuestDto dto);

}