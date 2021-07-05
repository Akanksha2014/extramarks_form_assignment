package com.form.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.form.data.User;
import com.form.service.UserService;

/** 
 * This FormController class works as web request handler for our application which processes incoming requests,prepare model and returns the view*/


@Controller
public class FormController {
	
	@Autowired
	UserService userService;
	
	//request to "/" will be handled by this mapping
	@RequestMapping("/")       
	public String register(Model model)      //Model class defines a holder for model attributes and controls the data flow in model object
	{
		
		//addAttribute adds the supplied attribute under the supplied name to model
		model.addAttribute("obj",new User());
		return "index";
	}
	  
	//mapping for saving the incoming user data and creating a view of supplied data
	@RequestMapping(value="/userDetails" , method=RequestMethod.POST)
	public String userInfo(User user, @RequestParam("image") MultipartFile file, Model model) throws IOException
	{    
		//processing and uploading files
		if(file.isEmpty())
		{
			System.out.println("Empty file");
		}
		else
		{
			user.setProimg(file.getOriginalFilename());
			File saveFile = new ClassPathResource("static/img").getFile();
			Path path = Paths.get(saveFile.getAbsolutePath()+File.pathSeparator+file.getOriginalFilename());
			Files.copy(file.getInputStream(),path , StandardCopyOption.REPLACE_EXISTING);
			
		}
		//saving the data in database
		 userService.insertData(user);
		 //adding the object to model for displaying and providing editing functionality
		 model.addAttribute("obj", user);
		 return "user_details";
		}
	
	//mapping for processing the incoming request of editing data of user with an id
    @RequestMapping(path="/editDetails/{id}")
    public String editUser(Model model,@PathVariable("id") Optional<Long> id)
    {
    	//getting data of user from database using id 
    		User user = userService.getUserById(id.get());
    		model.addAttribute("obj",user);
    	return "index";
    }
}
