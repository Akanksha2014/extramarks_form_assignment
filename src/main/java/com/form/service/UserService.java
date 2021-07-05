package com.form.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.form.dao.UserDao;
import com.form.data.User;

/** This UserService class provides logic to operate on the data sent to and from another classes and client*/


@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	//function returns the attributes of a user with a particular id
	public User getUserById(Long id)
	{
		Optional<User> user = userDao.findById(id);
			return user.get();
	}
	
	//for saving user data in database
	public User insertData(User user)
	{
		if(user.getId() == null)           //if the user details is null then save it in database
		{
			user=userDao.save(user);
			//user.setProimg(file.getOriginalFilename());
			return user;
		}
		else     
		{
			Optional<User> user1 = userDao.findById(user.getId());
			if(user1.isPresent())
			{
				User newUser = user1.get();
				newUser.setName(user.getName());
				newUser.setEmail(user.getEmail());
				newUser.setMobile(user.getMobile());
				newUser.setGender(user.getGender());
				newUser.setState(user.getState());
				newUser.setSkills(user.getSkills());
				//newUser.setProimg(file.getOriginalFilename());
				newUser = userDao.save(newUser);
				return newUser;
 			}
			else
			{
				user=userDao.save(user);
				//user.setProimg(file.getOriginalFilename());
				return user;
			}
		}
	}

}
