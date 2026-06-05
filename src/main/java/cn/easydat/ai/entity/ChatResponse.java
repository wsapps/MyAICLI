package cn.easydat.ai.entity;

import tools.jackson.databind.ObjectMapper;

public class ChatResponse {

	private String thinking;
	private String content;
	private ResUsage resUsage;

	public ChatResponse() {
		super();
	}

	public ChatResponse(String thinking, String content, ResUsage resUsage) {
		this.thinking = thinking;
		this.content = content;
		this.resUsage = resUsage;
	}

	public String getThinking() {
		return thinking;
	}

	public void setThinking(String thinking) {
		this.thinking = thinking;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ResUsage getResUsage() {
		return resUsage;
	}

	public void setResUsage(ResUsage resUsage) {
		this.resUsage = resUsage;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
