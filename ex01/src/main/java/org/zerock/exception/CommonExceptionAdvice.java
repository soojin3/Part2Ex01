package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice//모든 컨트롤러에 대해
@Log4j
public class CommonExceptionAdvice {
	//횡단관심사 (cross concern)
	//AOP를 이용
	///sample/ex01?name=aaa&age=AA		<- 예외 발생 방법
	@ExceptionHandler(Exception.class)//모든 예외 발생시
	public String except(Exception ex,Model model) {
		log.error("예외 발생했다.!");
		ex.printStackTrace();//서버쪽 콘솔에 찍기
		model.addAttribute("msg",ex.getMessage());
		model.addAttribute("msg2",ex);
		StackTraceElement[] list = ex.getStackTrace();
		for(StackTraceElement stack:list) {
			log.error(stack);
		}
		return "error";//error.jsp를 열어라
	}

}
