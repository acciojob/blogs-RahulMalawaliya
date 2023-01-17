package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blog
    	return blogRepository1.findAll();

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        //updating the blog details

        //Updating the userInformation and changing its blogs
    	Blog blog=new Blog();
    	blog.setTitle(title);
    	blog.setContent(content);
    	blog.setPubDate(new Date());
    	
    	User user=userRepository1.findById(userId).get();
    	List<Blog> blogs=user.getBlogList();
    	blogs.add(blog);
    	user.setBlogList(blogs);
    	userRepository1.save(user);
    	

    }

    public Blog findBlogById(int blogId){
        //find a blog
    	Blog blog=blogRepository1.findById(blogId).get();
    	return blog;
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
    	Image image=new Image();
    	image.setDimentions(dimensions);
    	image.setDescription(description);
    	Blog blog=blogRepository1.findById(blogId).get();
    	List<Image> images=blog.getImageList();
    	images.add(image);
    	blog.setImageList(images);
    	blogRepository1.save(blog);
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
    	blogRepository1.deleteById(blogId);
    }
}
