package cn.easydat.ai.entity;

import java.util.List;

import tools.jackson.databind.ObjectMapper;

public class Res {
	private String id;
	private String model;
	private String service_tier;
	private String object;
	private Long created;

	private ResUsage usage;

	private List<ResChoice> choices;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getService_tier() {
		return service_tier;
	}

	public void setService_tier(String service_tier) {
		this.service_tier = service_tier;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public ResUsage getUsage() {
		return usage;
	}

	public void setUsage(ResUsage usage) {
		this.usage = usage;
	}

	public List<ResChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<ResChoice> choices) {
		this.choices = choices;
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
