package com.search.sequence.commutebuddy.service;

import com.search.sequence.commutebuddy.dao.UserDao;
import com.search.sequence.commutebuddy.model.User;
import com.search.sequence.commutebuddy.model.UserDTO;
import com.search.sequence.commutebuddy.model.UserDTO;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
		
		@Autowired
		private UserDao userDao;
		
		private static final Logger log = LoggerFactory.getLogger(UserService.class);

	    
	    public User getUserById(long id) {
	    	log.info("Getting user by userId: " + id);
	    	User user = userDao.getUserById(id);
	    	
	    	return user;
	    	
	    }

	    public List<User> getAllUsers() {
	    	log.info("Getting list of all users");
	    	List<User> userList = userDao.getAllUsers();
	    	
	    	return userList;
	    	
	    }
	    
	    
	    public long ceateUser(UserDTO userDTO) {
	    	log.info("Create user using userDTO, newly created account loginId: " + userDTO.getUserCredential().getLoginId());
	    	//String sql = "INSERT INTO users (loginId, loginPassword, password) VALUES (?, ?, ?)";
	    	
	    	
	    	userDTO.getUser().setAccountCreated(new Date());
	    	userDTO.getUser().setActive(false);
	    	
	    	
	    	
	    	return userDao.save(userDTO.getUser());
	    	
	    }
	    
	}

	