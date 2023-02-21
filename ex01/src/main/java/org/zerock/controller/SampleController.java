package org.zerock.controller;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*") // get,post모든 요청을 받음
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("기본요청...");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic 요청");
		// 리턴타입이 void일 경우에는 요청한 url.jsp 파일로 응답
	}

	@GetMapping("/basicOnlyGet") // 스프링 4.3 이상부터 지원
	public void basicGet2() {
		log.info("basionOnlyGet 요청 ..");

	}

	@GetMapping
	public String ex01(@RequestParam("name") String name2, int age, SampleDTO dto) {
		// @RequestParam(DTO에서의 이름)String "내가 사용할 이름"
		log.info("ex01 요청 이름: " + name2 + "나이: " + age);
		log.info(dto);
		return "sampe/ex01";// 절대경로로 작성해야 한다. 리턴타입이 string 인 경우 문자열 .jsp 파일로 응답
							// ex01-> views/ex01.jsp로 이동
							// sample/ex01 -> sample/ex01.jsp로 이동
	}

	@GetMapping("ex02Array")
	public void ex02Array(String[] ids) {
		log.info("array ids: " + Arrays.toString(ids));
	}

	@GetMapping("ex02List")
	// sample/ex02List?ids=11&ids=9
	// =>array ids: [11, 9]
	public void ex02Array(@RequestParam("ids") ArrayList<String> ids) {
		// List일 경우에는 같은 이름이라도 RequestParam 생략불가
		log.info("array ids: " + ids);
	}

	// 전송하는 url형태
	// sample/ex02Bean?list[0].name=aaa&list[0].age=10&list[1].name=vv&list[1].age=20
	// ex02Bean?list%5B0%5D.name=aaa&list%5B0%5D.age=10&list%5B1%5D.name=vv&list%5B1%5D.age=20
	// [ => %5B ] => %5D 이렇게 고쳐야 한다.
	@GetMapping("/ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		log.info("list dtos: " + list);
	}

	@GetMapping("ex03")
	public void ex03(TodoDTO todo) {
		log.info("todo: " + todo);
	}

	@GetMapping("ex03start")
	public void ex03start() {

	}

	/*
	 * 날짜 자동변환 or 날짜타입 선언한는 곳에 @DateTimeFormate 둘 중 하나 선택
	 * 
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateformat = new SimpleDateFormat("yyyy-mm-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateformat, false)); }
	 */

	@RequestMapping("modeltest")
	public void modeltest(Model model) {
		Date now = new java.util.Date();
		log.info("현재시간 : " + now);
		model.addAttribute(now);// 이름 생략시 객체타입 앞글자 소문자로
		model.addAttribute("time", now);
	}

	// 테스트 url -> 열린페이지 /sample/ex04.jsp
	// sample/ex04?name=myname&age=90&page=3
	@RequestMapping("ex04")
	public void ex04(@ModelAttribute("aaa") SampleDTO dto, @ModelAttribute("page") int page, String name) {
		// 1. 자바빈즈 객체에 아닌 기본 데이터 타입일 경우
		// ModelAttribute "page"는 form에서
		// name으로 보내온 parameter value와 model로 보내는 value로 보내는 value name 동시에 의미함
		// 즉 ModelAttribute가 RequestParam 기능과 Model로 데이터 보내는 기능을 처리
		// 2. 자바빈즈일때는 그냥 model 로 보내는 이름이 됨(생략하면 자바빈즈는 객체이름으로 자동전달)
		log.info("객체수집: " + dto);
		log.info("이름: " + name);
		log.info("page 수집: " + page);
	}

	@RequestMapping("ex04ex")
	public void ex04ex(SampleDTO dto, int page, String name, Model model) {
		model.addAttribute("aaa", dto);
		model.addAttribute("page2", page);
		log.info("page 수집: " + page);
	}

	@RequestMapping("rd")
	public void rd() {

	}

	@RequestMapping("dbwrite")
	public String dbwrite(Model model, String str,RedirectAttributes rddr) {
		log.info("db에 작성합니다.");
		
		rddr.addFlashAttribute("aaa", "Alert good");//경고창에 1번만 나온다.
		
		model.addAttribute("ccc", "~good~");//리다이렉트라면 param으로 전송
		return "redirect:/sample/dbwrite2";// 페이지가 아님 url이다.
	}

	@RequestMapping("dbwrite2")
	public String dbwrite2(Model model) {
		log.info("db2에 작성합니다.");
		
		model.addAttribute("bbb", "gogoggog");
		//model.addAttribute("aaa", "성공입니다.");Alert할때 이거 쓰면 계속 뜸 쓰지 말아라
		return "/dbwrite";// 페이지가 아님 url이다.
	}
}
