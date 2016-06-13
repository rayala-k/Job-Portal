package com.neu.jobportal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Keyword")
public class Keyword {

	@Id
	@GeneratedValue
	@Column(name = "keywordID", unique = true, nullable = false)
	private long keywordID;

	@Column(name = "keyWordName", unique = true, nullable = false)
	private String keyWordName;

	public Keyword() {

	}

	public Keyword(String name) {
		this.keyWordName = name;
	}

	public long getKeywordID() {
		return keywordID;
	}

	public void setKeywordID(long keywordID) {
		this.keywordID = keywordID;
	}

	public String getKeyWordName() {
		return keyWordName;
	}

	public void setKeyWordName(String keyWordName) {
		this.keyWordName = keyWordName;
	}

}
