package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    
    @Autowired
    BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
    	Image image=new Image();
    	image.setDimentions(dimensions);
    	image.setDiscription(description);
    	List<Image> images=blog.getImages();
    	images.add(image);
    	blog.setImages(images);
    	return image;
    }

    public void deleteImage(Image image){
    	
    	imageRepository2.delete(image);

    }

    public Image findById(int id) {
    	Image image=imageRepository2.findById(id).get();
    	return image;
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
    	 String dimensions = image.getDimentions();
         int xi = 0;
         int yi = 0;
         int xs = 0;
         int ys = 0;
         int num = 0;
         for(int i = 0; i<dimensions.length(); i++){
             if(dimensions.charAt(i) == 'X'){
                 xi = num;
                 num = 0;
                 continue;
             }
             num *= 10;
             num += (dimensions.charAt(i) - '0');
         }
         yi = num;
         num = 0;
         for(int i = 0; i<screenDimensions.length(); i++){
             if(screenDimensions.charAt(i) == 'X'){
                 xs = num;
                 num = 0;
                 continue;
             }
             num *= 10;
             num += (screenDimensions.charAt(i) - '0');
         }
         ys = num;

         int ans = (int) (Math.floor((new Double(xs))/(new Double(xi))) * Math.floor((new Double(ys))/(new Double(yi))));
         return ans;

    }
}
