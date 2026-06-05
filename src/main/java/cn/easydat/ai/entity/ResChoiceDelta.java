package cn.easydat.ai.entity;

import tools.jackson.databind.ObjectMapper;

public class ResChoiceDelta {
	private String content;
	private String reasoning_content;
	private String role;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReasoning_content() {
		return reasoning_content;
	}

	public void setReasoning_content(String reasoning_content) {
		this.reasoning_content = reasoning_content;
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
