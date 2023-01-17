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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDimensions() {
		return Dimensions;
	}

	public void setDimensions(String dimensions) {
		Dimensions = dimensions;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Image(int id, String description, String dimensions, Blog blog) {
		super();
		this.id = id;
		Description = description;
		Dimensions = dimensions;
		this.blog = blog;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}