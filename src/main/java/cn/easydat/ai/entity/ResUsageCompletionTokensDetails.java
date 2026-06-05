package cn.easydat.ai.entity;

import tools.jackson.databind.ObjectMapper;

public class ResUsageCompletionTokensDetails {
	private Integer reasoning_tokens;

	public Integer getReasoning_tokens() {
		return reasoning_tokens;
	}

	public void setReasoning_tokens(Integer reasoning_tokens) {
		this.reasoning_tokens = reasoning_tokens;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
