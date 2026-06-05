package cn.easydat.ai.entity;

public class ReqThinking {

	private String type;
	
	public ReqThinking() {
		this.type = "enabled";
	}
	
	public ReqThinking(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
