package com.driver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name = "Image")
public class Image
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Discription;
	
	private String Dimentions;
	
	@ManyToOne
	@JoinColumn
	private Blog blog;

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}

	public String getDimentions() {
		return Dimentions;
	}

	public void setDimentions(String dimentions) {
		Dimentions = dimentions;
	}

	public Image(String discription, String dimentions) {
		super();
		Discription = discription;
		Dimentions = dimentions;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}