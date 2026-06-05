package cn.easydat.ai.entity;

import java.util.List;

import tools.jackson.databind.ObjectMapper;

public class Req {

	private List<ReqMsg> messages;
	private String model;
	private Boolean stream;
	private ReqThinking thinking;
	private ReqStreamOptions stream_options;

	public Req() {
	}

	public Req(String model, List<ReqMsg> messages) {
		this.messages = messages;
		this.model = model;
		this.stream = true;
		this.stream_options = new ReqStreamOptions(true, false);
	}

	public Req(List<ReqMsg> messages, String model, Boolean stream, ReqThinking thinking,
			ReqStreamOptions stream_options) {
		this.messages = messages;
		this.model = model;
		this.stream = stream;
		this.thinking = thinking;
		this.stream_options = stream_options;
	}

	public List<ReqMsg> getMessages() {
		return messages;
	}

	public void setMessages(List<ReqMsg> messages) {
		this.messages = messages;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getStream() {
		return stream;
	}

	public void setStream(Boolean stream) {
		this.stream = stream;
	}

	public ReqThinking getThinking() {
		return thinking;
	}

	public void setThinking(ReqThinking thinking) {
		this.thinking = thinking;
	}

	public ReqStreamOptions getStream_options() {
		return stream_options;
	}

	public void setStream_options(ReqStreamOptions stream_options) {
		this.stream_options = stream_options;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
