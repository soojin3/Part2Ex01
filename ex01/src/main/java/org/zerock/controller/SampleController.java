package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")//get,post모든 요청을 받음
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("기본요청...");
	}
	@RequestMapping(value="/basic",method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic 요청");
		//리턴타입이 void일 경우에는 요청한 url.jsp 파일로 응답
	}
	
	@GetMapping("/basicOnlyGet")//스프링 4.3 이상부터 지원
	public void basicGet2() {
		log.info("basionOnlyGet 요청 ..");
		
	}
	@GetMapping
	public String ex01(String name,int age,SampleDTO dto) {
		log.info("ex01 요청 이름: "+name+"나이: "+age);
		log.info(dto);
		return "sampe/ex01";//절대경로로 작성해야 한다. 리턴타입이 string 인 경우 문자열 .jsp 파일로 응답
							//ex01-> views/ex01.jsp로 이동
							//sample/ex01 -> sample/ex01.jsp로 이동
	}
	
	
}
