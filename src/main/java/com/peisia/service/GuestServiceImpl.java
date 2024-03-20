package com.peisia.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.peisia.board.ConfigBoard;
import com.peisia.dto.GuestDto;
import com.peisia.dto.PagingDto;
import com.peisia.mapper.GuestMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

	// GuestMapper 인터페이스를 주입받음
	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;

	@Override
	public List<GuestDto> getList(int page) {
		log.info("비지니스 계층===========");
		// GuestMapper를 사용하여 특정 페이지에 해당하는 게시물 리스트를 가져옴
		return mapper.getList(page);
	}

	@Override
	public int getStartIndex(int page) {
		// 특정 페이지에 해당하는 게시물 목록을 가져오기 위해 필요한 시작 인덱스를 계산
		int index = (page - 1) * ConfigBoard.AMOUNT_PER_PAGE;
		return index;
	}

	@Override
	public int getTotalCount() {
		// GuestMapper를 사용하여 전체 게시물 수를 가져옴
		return mapper.getTotalCount();
	}

	@Override
	public int getTotalPage() {
		// 전체 페이지 수 계산
		int totalCount = getTotalCount();
		int totalPage = 0;
		if (totalCount % ConfigBoard.AMOUNT_PER_PAGE == 0) {
			totalPage = totalCount / ConfigBoard.AMOUNT_PER_PAGE;
		} else {
			totalPage = totalCount / ConfigBoard.AMOUNT_PER_PAGE + 1;
		}
		return totalPage;
	}

	@Override
	public int getTotalBlock(int totalPage) {
		// 전체 블록 수 계산
		int totalBlock = 0;
		if (totalPage % ConfigBoard.PAGE_PER_BLOCK == 0) {
			totalBlock = totalPage / ConfigBoard.PAGE_PER_BLOCK;
		} else {
			totalBlock = totalPage / ConfigBoard.PAGE_PER_BLOCK + 1;
		}
		return totalBlock;
	}

	@Override
	public GuestDto read(long bno) {
		// GuestMapper를 사용하여 특정 게시물을 읽어옴
		return mapper.read(bno);
	}

	@Override
	public void del(long bno) {
		// GuestMapper를 사용하여 특정 게시물을 삭제
		mapper.del(bno);
	}

	@Override
	public void write(GuestDto dto) {
		// GuestMapper를 사용하여 새로운 게시물을 작성
		mapper.write(dto);
	}

	@Override
	public void modify(GuestDto dto) {
		// GuestMapper를 사용하여 게시물을 수정
		mapper.modify(dto);
	}
}