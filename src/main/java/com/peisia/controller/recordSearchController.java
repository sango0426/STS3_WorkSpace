package com.peisia.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.peisia.dto.LolDto;
import com.peisia.dto.RankDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/recordSearch/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@Controller
public class recordSearchController {

	@GetMapping("/recordSearch")
	public static void userName(Model model, @RequestParam("userName") String userName) {
		String encName = encodeSpaces(userName);
		// 인코딩 인증키
		String API_KEY = "RGAPI-f8a31b8f-929b-4f19-8133-2e7165bbfbf3";
		String API_URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + encName + "?api_key="
				+ API_KEY;

		RestTemplate restTemplate = new RestTemplate();

		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		LolDto lol = restTemplate.getForObject(uri, LolDto.class); // 자기 클래스로 바꾸시오..
		log.info("==== json ==== : 페이커 닉네임 잘나오니 : " + lol.name);

		String id = lol.id;
		String userNm = lol.name;
		model.addAttribute("userName", userNm);
		int userLevel = lol.summonerLevel;
		model.addAttribute("userLevel", userLevel);

		String API_URL_RANK = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + id + "?api_key="
				+ API_KEY;

		//// **** 중요 **** uri
		URI uri_rank = null; // java.net.URI 임포트 하셈
		try {
			uri_rank = new URI(API_URL_RANK); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		ResponseEntity<RankDto[]> responseEntity = restTemplate.getForEntity(uri_rank, RankDto[].class);
		RankDto[] rankDtos = responseEntity.getBody();

		// 랭크 정보가 배열로 오기 때문에 첫 번째 요소를 사용
		if (rankDtos.length > 0) {
			RankDto lol_rank = rankDtos[0];
			String userRank = lol_rank.rank;
			model.addAttribute("userRank", userRank);
			String userTier = lol_rank.tier;
			model.addAttribute("userTier", userTier);
			int userWins = lol_rank.wins;
			model.addAttribute("userWins", userWins);
			int userLosses = lol_rank.losses;
			model.addAttribute("userLosses", userLosses);
		} else {
			// 랭크 정보가 없을 경우에 대한 처리
			log.warn("랭크 정보가 없습니다.");
		}
	}

	private static String encodeSpaces(String input) {
		try {
			// URLEncoder를 사용하여 공백을 %20으로 변환
			return URLEncoder.encode(input, "UTF-8").replace(" ", "%20");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return input; // 변환이 실패하면 원래 문자열 반환
		}
	}
}