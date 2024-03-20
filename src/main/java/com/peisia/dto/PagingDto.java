package com.peisia.dto;

import lombok.Data;

@Data
public class PagingDto {
	private int limitIndex;
	private int totalBlock;
	private int currentBlockNo;
	private int blockStartNo;
	private int blockEndNo;
	private int totalPage;
	private int currentPage;
	private int prevPage;
	private int nextPage;
	private boolean hasPrev;
	private boolean hasNext;
	public String word;
	
	public PagingDto(int totalBlock, int currentBlockNo, int blockStartNo, int blockEndNo,
			int totalPage, int currentPage, int prevPage, int nextPage, String word) {
		this.totalBlock = totalBlock;
		this.currentBlockNo = currentBlockNo;
		this.blockStartNo = blockStartNo;
		this.blockEndNo = blockEndNo;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
		this.word = word;
	}
}
