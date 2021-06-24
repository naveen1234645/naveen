package org.example.demo.model;

public class InternationalCD extends CD {

	private Integer cdId;
	private String cdName;
	private String language;

	public InternationalCD() {

	}

	public InternationalCD(Integer cdId, String cdName, String language) {
		this.cdId = cdId;
		this.cdName = cdName;
		this.language = language;
	}

	public Integer getCdId() {
		return cdId;
	}

	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}

	public String getCdName() {
		return cdName;
	}

	public void setCdName(String cdName) {
		this.cdName = cdName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return "CD ID" + cdId + " CD Name: " + cdName + " CD Language: " + language;
	}

}