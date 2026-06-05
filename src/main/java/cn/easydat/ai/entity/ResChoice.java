package cn.easydat.ai.entity;

import tools.jackson.databind.ObjectMapper;

public class ResChoice {

	private Integer index;
	private ResChoiceDelta delta;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public ResChoiceDelta getDelta() {
		return delta;
	}

	public void setDelta(ResChoiceDelta delta) {
		this.delta = delta;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
