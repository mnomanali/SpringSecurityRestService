package com.search.sequence.commutebuddy.service;

import com.search.sequence.commutebuddy.dao.UserDao;
import com.search.sequence.commutebuddy.model.User;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	}

	