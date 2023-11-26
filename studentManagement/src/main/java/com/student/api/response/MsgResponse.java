package com.student.api.response;

import lombok.Data;

@Data
public class MsgResponse {
	private int status;
	private String message;
	private Object data;   // Object can handle any type of data;
}
