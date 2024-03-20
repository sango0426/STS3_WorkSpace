package com.peisia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.board.ConfigBoard;
import com.peisia.dto.GuestDto;
import com.peisia.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@AllArgsConstructor // 필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌.
@Controller
public class GuestController {

	private GuestService service;

	// 게시물 리스트를 가져와서 페이징 처리를 한 후 모델에 담아 화면에 전달하는 메서드
	@GetMapping("/getList")
	public void getList(Model model, @RequestParam("page") int page) {
		int index = service.getStartIndex(page);
		int totalCount = service.getTotalCount();
		int totalPage = service.getTotalPage();
		int totalBlock = service.getTotalBlock(totalPage);
		int currentBlock = (int) Math.ceil((double) page / ConfigBoard.PAGE_PER_BLOCK);
		int blockStartNo = (currentBlock - 1) * ConfigBoard.PAGE_PER_BLOCK + 1;
		int blockEndNo = currentBlock * ConfigBoard.PAGE_PER_BLOCK;

		boolean hasPrev = (currentBlock != 1);
		boolean hasNext = (currentBlock < totalBlock);
		int prevPage = hasPrev ? (currentBlock - 1) * ConfigBoard.PAGE_PER_BLOCK : 0;
		int nextPage = hasNext ? currentBlock * ConfigBoard.PAGE_PER_BLOCK + 1 : 0;

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalBlock", totalBlock);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("blockStartNo", blockStartNo);
		model.addAttribute("blockEndNo", blockEndNo);
		model.addAttribute("hasPrev", hasPrev);
		model.addAttribute("hasNext", hasNext);
		model.addAttribute("prevPage", prevPage);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("list", service.getList(index));
	}

	// 특정 게시물을 읽어오거나 수정하는 화면으로 이동하는 메서드
	@GetMapping({ "/read", "/modify" })
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		model.addAttribute("read", service.read(bno));
	}

	// 특정 게시물을 삭제하는 메서드
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		service.del(bno);
		return "redirect:/guest/getList";
	}

	// 새로운 게시물을 작성하는 화면으로 이동하는 메서드
	@GetMapping("/write")
	public void write() {
	}

	// 새로운 게시물을 작성하고 리스트로 돌아가는 메서드
	@PostMapping("/write")
	public String write(GuestDto dto) {
		service.write(dto);
		return "redirect:/guest/getList";
	}

	// 게시물을 수정하고 리스트로 돌아가는 메서드
	@PostMapping("/modify")
	public String modify(GuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList";
	}
	
	@RequestMapping("/test")
	public void test(HttpServletRequest request,Model m) {
		setCp(m,request.getContextPath());
		m.addAttribute("a","개");
		m.addAttribute("b","삵");
	}
	
	public void setCp(Model m, String cp) {
		m.addAttribute("cp",cp);
		log.info("==== 컨텍스트 패스임:"+cp);
	}
	
	@RequestMapping("/test2")
	public void test2() {
		
	}
	
	@RequestMapping("/testapi")
	public void testapi() {
		
	}
}