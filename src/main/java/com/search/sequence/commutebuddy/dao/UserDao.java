package com.search.sequence.commutebuddy.dao;


import com.search.sequence.commutebuddy.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

		private static final Logger log = LoggerFactory.getLogger(UserDao.class);
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		/*
		 * private static final String SUBMISSION_TOTAL =
			SELECT userId, firstName, lastName, address1, address2, province, city, telephone1, telephone2, gender, accountCreated, accountUpdated, 
			active, email, sendOffers, userRating 
			FROM cbd_user
			where userId =  ? 

		 */
		
		private static final String SQL_USER_BY_ID = "SELECT userId, firstName, lastName, address1, address2, province, city, telephone1, telephone2, gender, " +
							" accountCreated, accountUpdated, active, email, sendOffers, userRating " + 
							" FROM cbd_user " + 
							" where userId =  ? ";
		
		private static final String SQL_ALL_USERS = "SELECT userId, firstName, lastName, address1, address2, province, city, telephone1, telephone2, gender, " +
				" accountCreated, accountUpdated, active, email, sendOffers, userRating " + 
				" FROM cbd_user ";
			
		
		public User getUserById(long id) {
	    	User user = null;
	    	
	    	try {
	    		log.info("Sql user by userId:  " + SQL_USER_BY_ID);
	    		
	    		user = jdbcTemplate.queryForObject(SQL_USER_BY_ID, new UserByIdMapper(), id);
	    		
	    	} catch (Exception e) {
	    		log.error("submission sql error: " + e.getMessage() + "\n" + e.getCause());
	    		throw new RuntimeException("Internal server error. Please, reach out to Administrator");

	    	}
	        return user;
		}

		public List<User> getAllUsers() {
	    	List<User> userList = null;
	    	
	    	try {
	    		log.info("Sql all users:  " + SQL_ALL_USERS);
	    		
	    		userList = jdbcTemplate.query(SQL_ALL_USERS, new UserByIdMapper());
	    		
	    	} catch (Exception e) {
	    		log.error("all users sql error: " + e.getMessage() + "\n" + e.getCause());
	    		throw new RuntimeException("Internal server error. Please, reach out to Administrator");

	    	}
	        return userList;
		}

	    private class  UserByIdMapper implements RowMapper<User> {
	    	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			  	User user = new User();
			  	
			  	user.setUserId(rs.getLong("userId"));
			  	user.setFirstName(rs.getString("firstName"));
			  	user.setLastName(rs.getString("lastName"));
			  	user.setAddress1(rs.getString("address1"));
			  	user.setAddress2(rs.getString("address2"));
			  	user.setProvince(rs.getString("province"));
			  	user.setCity(rs.getString("city"));
			  	user.setTelephone1(rs.getString("Telephone1"));
			  	user.setTelephone2(rs.getString("Telephone2"));
			  	user.setGender(rs.getString("gender"));
			  	user.setAccountCreated(rs.getDate("accountCreated"));
			  	user.setAccountUpdated(rs.getDate("accountUpdated"));
			  	user.setActive(rs.getBoolean("active"));
			  	user.setEmail(rs.getString("email"));
			  	user.setSendOffers(rs.getBoolean("sendOffers"));
			  	user.setUserRating(rs.getInt("userRating"));

		        return user;
		    }
	    }
	    
	 
    	public long save(User user) {
    		  SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
    		          .withTableName("cbd_user")
    		          .usingGeneratedKeyColumns("userId");
    		  return simpleJdbcInsert.executeAndReturnKey(user.toMap()).longValue();
    		}
	    

	}