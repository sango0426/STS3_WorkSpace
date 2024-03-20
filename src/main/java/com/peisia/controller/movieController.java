package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.MovieDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/movie/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@Controller
public class movieController {

	@GetMapping("/getMovieList")
	public void w(Model model, @RequestParam("date")String date) {
		
		date = date.replace("-", "");
		// 인코딩 인증키
		String API_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + date;

		RestTemplate restTemplate = new RestTemplate();

		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		MovieDto movie = restTemplate.getForObject(uri, MovieDto.class); // 자기 클래스로 바꾸시오..
		log.info("==== json ==== : 1번 영화 잘 나오니? : " + movie.boxOfficeResult.dailyBoxOfficeList.get(0).movieNm);
		int movieSize = movie.boxOfficeResult.dailyBoxOfficeList.size();
		model.addAttribute("movieSize", movieSize);
		String searchDate = movie.boxOfficeResult.showRange;
		model.addAttribute("searchDate", searchDate);
		List<String> movieName = new ArrayList<>();
		List<String> movieNum = new ArrayList<>();
		List<String> movieRank = new ArrayList<>();
		List<String> movieSales = new ArrayList<>();
		List<String> movieOpen = new ArrayList<>();
		for(int i = 0; i < movieSize; i++) {
			movieName.add(movie.boxOfficeResult.dailyBoxOfficeList.get(i).movieNm);
		    movieNum .add(movie.boxOfficeResult.dailyBoxOfficeList.get(i).rnum);
		    movieRank.add(movie.boxOfficeResult.dailyBoxOfficeList.get(i).rank);
		    movieSales.add(movie.boxOfficeResult.dailyBoxOfficeList.get(i).salesAcc);
		    movieOpen.add(movie.boxOfficeResult.dailyBoxOfficeList.get(i).openDt);
		}
		    // 영화 정보를 Model에 추가
		    model.addAttribute("movieName", movieName);
		    model.addAttribute("movieNum", movieNum);
		    model.addAttribute("movieRank", movieRank);
		    model.addAttribute("movieSales", movieSales);
		    model.addAttribute("movieOpen", movieOpen);

		    String ddara = String.format("\n조회한 날짜 : %s\n"
		            + "영화 번호 : %s\n" + "영화 이름 : %s\n" + "영화 순위 : %s\n" + "영화 누적 매출액 : %s\n"
		            , searchDate, movieNum, movieName, movieRank, movieSales);
		    log.info("콘솔 확인용\n" + ddara);
		}
}