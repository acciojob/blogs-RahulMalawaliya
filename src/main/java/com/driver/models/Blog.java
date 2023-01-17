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
	
	private Date PubDate;
	
	@OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
	private List<Image> ImageList;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public Blog(int id, String title, String content, Date pubDate, List<Image> images, User user) {
		super();
		this.id = id;
		Title = title;
		Content = content;
		PubDate = pubDate;
		this.ImageList = images;
		this.user = user;
	}

	public List<Image> getImageList() {
		return ImageList;
	}

	public void setImageList(List<Image> imageList) {
		ImageList = imageList;
	}

	public Date getPubDate() {
		return PubDate;
	}

	public void setPubDate(Date pubDate) {
		PubDate = pubDate;
	}

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}