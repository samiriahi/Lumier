package com.supportportal.service;

import com.supportportal.domain.User;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;

import com.supportportal.exception.domain.EmailNotFoundException;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
    
    User addNewUser (String firstName , String lastName , String username , String email ,String role, boolean isNotLoked  , boolean isActive , MultipartFile profileImage ) throws UsernameExistException, EmailExistException, IOException ;

	User updateUser (String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNotLoked  , boolean isActive , MultipartFile profileImage ) throws UsernameExistException, EmailExistException, IOException ;

	void deleteUser (long id ) ;
	
	void resetPassword (String email ) throws EmailNotFoundException ;
	                                                                            
	User updateProfileImage (String username , MultipartFile profileImage) throws UsernameExistException, EmailExistException, IOException ;
	
    
}
