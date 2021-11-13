package com.search.sequence.commutebuddy.controller;


import com.search.sequence.commutebuddy.model.User;
import com.search.sequence.commutebuddy.model.UserDTO;
import com.search.sequence.commutebuddy.model.UserDTO;
import com.search.sequence.commutebuddy.service.UserService;
import com.search.sequence.commutebuddy.utils.ApiResponse;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
		
		private static final Logger log = LoggerFactory.getLogger(UserController.class);
		

		@Autowired
	    private UserService userService;

		//@Autowired
		//private ConfigUtility configUtil;
		
	    @GetMapping("/{userId}")
	    public ApiResponse<User> getUserById(@PathVariable int userId) {
	    	
	    	//log.info("List of allowed groups: --------------------------- " + configUtil.getProperty("allowed.groups"));
	    	User user = userService.getUserById(userId);
	        return new ApiResponse<User>(HttpStatus.OK.value(), "User Information!", "mali", user);
	    }
		
		@GetMapping
		public ApiResponse<List<User>> getAllUser() { 
			
			List<User> userList = userService.getAllUsers();
			
		
			return new ApiResponse<List<User>>(HttpStatus.OK.value(), "Fetched successfull", "mali", userList); 
		}
		
		//@RequestMapping(value = "/", method = RequestMethod.POST) 
		@PostMapping
		public ApiResponse<String> createuser(@RequestBody UserDTO userDTO) { 
			
			log.info("UserDTO: " + userDTO.getUser().getFirstName());

			userService.ceateUser(userDTO);
	        log.info("Account is ready to be created: " + userDTO.toString());
		
			
			return new ApiResponse<String>(HttpStatus.OK.value(), "Fetch successfully", "mali", "User account created successfully");
		}	
		
}



