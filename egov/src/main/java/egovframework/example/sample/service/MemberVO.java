package egovframework.example.sample.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import egovframework.example.sample.common.ListToStringDeserializer;

import java.util.List;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	@JsonDeserialize(using = ListToStringDeserializer.class)
	private String computer;
	public MemberVO() {};

	public MemberVO(String id, List<List<Integer>> computerData) {
		this.id = id;
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.computer = mapper.writeValueAsString(computerData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			this.computer = "[]";
		}
	}
	public MemberVO( String id, String pw, String name, String computer) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.computer = computer;
	}
	public MemberVO(String computer) {
		this.computer = computer;
	}


	public List<List<Integer>> getComputerAsList() {
		try {
			return new ObjectMapper().readValue(this.computer, List.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	

}
