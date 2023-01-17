package com.driver.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Blog")
public class Blog
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Title;
	
	private String Content;
	
	private Date Publish_Date;
	
	@OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
	private List<Image> images;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn
	private User user;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getPublish_Date() {
		return Publish_Date;
	}

	public void setPublish_Date(Date publish_Date) {
		Publish_Date = publish_Date;
	}

	public Blog(String title, String content, Date publish_Date) {
		super();
		Title = title;
		Content = content;
		Publish_Date = publish_Date;
	}

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}