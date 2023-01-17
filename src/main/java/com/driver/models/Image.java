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
	
	private String Description;
	
	private String Dimensions;
	
	@ManyToOne
	@JoinColumn
	private Blog blog;

	public String getDiscription() {
		return Description;
	}

	public void setDescription(String discription) {
		Description = discription;
	}

	public String getDimentions() {
		return Dimensions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDimentions(String dimentions) {
		Dimensions = dimentions;
	}

	public Image(String discription, String dimentions) {
		super();
		Description = discription;
		Dimensions = dimentions;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	
	
}