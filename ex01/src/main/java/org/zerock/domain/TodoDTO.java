package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dueDate;//날짜는 자동변환되서 수집이 안된다. 
	

}
