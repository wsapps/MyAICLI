package cn.easydat.ai.entity;

import tools.jackson.databind.ObjectMapper;

public class ReqMsg {

	private String role;
	private String content;

	public ReqMsg() {
	}

	public ReqMsg(String role, String content) {
		this.content = content;
		this.role = role;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
