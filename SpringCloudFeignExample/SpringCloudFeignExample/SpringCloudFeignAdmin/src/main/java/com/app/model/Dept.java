package com.app.model;

public class Dept {

	private Integer id;
	private String code;
	private String type;
	public Dept() {
		super();
	}
	public Dept(Integer id, String code, String type) {
		super();
		this.id = id;
		this.code = code;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", code=" + code + ", type=" + type + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
