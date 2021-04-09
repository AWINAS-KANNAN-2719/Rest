package com.tutorialpoint.rest.Bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "USER")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5190496268219386316L;
	/**
	 * 
	 */
	@XmlAttribute(name = "ID")
	private int id;
	@XmlElement(name = "NAME")
	private String name;
	@XmlElement(name = "PROFESSION")
	private String profession;
	@XmlElement(name = "TEAM")
	private String team;

	public User() {

	}

	public User(int id, String name, String profession, String team) {
		super();
		this.id = id;
		this.name = name;
		this.profession = profession;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	//@XmlElement(name = "ID")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	//@XmlElement(name = "NAME")
	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	//@XmlElement(name = "PROFESSION")
	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getTeam() {
		return team;
	}

	//@XmlElement(name = "TEAM")
	public void setTeam(String team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", profession=" + profession + ", team=" + team + "]";
	}
}
