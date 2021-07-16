package com.mtl.mokolo.dto;
public class ReferenceDto {
	private Long value;
	private String label;
	public ReferenceDto(Long value, String label) {
		super();
		this.value = value;
		this.label = label;
	}
	public ReferenceDto() {
		super();
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
