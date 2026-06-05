package cn.easydat.ai.entity;

public class ReqStreamOptions {

	private Boolean include_usage;
	private Boolean chunk_include_usage;

	public ReqStreamOptions() {
	}

	public ReqStreamOptions(Boolean include_usage, Boolean chunk_include_usage) {
		this.include_usage = include_usage;
		this.chunk_include_usage = chunk_include_usage;
	}

	public Boolean getInclude_usage() {
		return include_usage;
	}

	public void setInclude_usage(Boolean include_usage) {
		this.include_usage = include_usage;
	}

	public Boolean getChunk_include_usage() {
		return chunk_include_usage;
	}

	public void setChunk_include_usage(Boolean chunk_include_usage) {
		this.chunk_include_usage = chunk_include_usage;
	}

}
