package cn.easydat.ai.entity;

import tools.jackson.databind.ObjectMapper;

public class ResUsage {
	private Integer completion_tokens;
	private Integer prompt_tokens;
	private Integer total_tokens;

	private Integer prompt_cache_hit_tokens;
	private Integer prompt_cache_miss_tokens;

	private ResUsageCompletionTokensDetails completion_tokens_details;

	public Integer getCompletion_tokens() {
		return completion_tokens;
	}

	public void setCompletion_tokens(Integer completion_tokens) {
		this.completion_tokens = completion_tokens;
	}

	public Integer getPrompt_tokens() {
		return prompt_tokens;
	}

	public void setPrompt_tokens(Integer prompt_tokens) {
		this.prompt_tokens = prompt_tokens;
	}

	public Integer getTotal_tokens() {
		return total_tokens;
	}

	public void setTotal_tokens(Integer total_tokens) {
		this.total_tokens = total_tokens;
	}

	public Integer getPrompt_cache_hit_tokens() {
		return prompt_cache_hit_tokens;
	}

	public void setPrompt_cache_hit_tokens(Integer prompt_cache_hit_tokens) {
		this.prompt_cache_hit_tokens = prompt_cache_hit_tokens;
	}

	public Integer getPrompt_cache_miss_tokens() {
		return prompt_cache_miss_tokens;
	}

	public void setPrompt_cache_miss_tokens(Integer prompt_cache_miss_tokens) {
		this.prompt_cache_miss_tokens = prompt_cache_miss_tokens;
	}

	public ResUsageCompletionTokensDetails getCompletion_tokens_details() {
		return completion_tokens_details;
	}

	public void setCompletion_tokens_details(ResUsageCompletionTokensDetails completion_tokens_details) {
		this.completion_tokens_details = completion_tokens_details;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
