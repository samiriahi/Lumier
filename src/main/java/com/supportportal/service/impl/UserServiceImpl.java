package com.supportportal.service.impl;

import com.supportportal.domain.User;
import com.supportportal.domain.UserPrincipal;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.UsernameExistException;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.EmailService;
import com.supportportal.service.LoginAttemptService;
import com.supportportal.service.UserService;

import com.supportportal.enumeration.Role;
import com.supportportal.exception.domain.EmailNotFoundException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import static com.supportportal.constant.FileConstant.*;
import static com.supportportal.constant.UserImplConstant.DEFAULT_USER_IMAGE_PATH;
import static com.supportportal.constant.UserImplConstant.*;
import static com.supportportal.enumeration.Role.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private UserRepository userRepository ;
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private BCryptPasswordEncoder passwordEncoder ; 
	private LoginAttemptService loginAttemptService ;
	private EmailService emailService ;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository , BCryptPasswordEncoder passwordEncoder ,LoginAttemptService loginAttemptService ,  EmailService emailService   ) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder ;
		this.loginAttemptService = loginAttemptService ;
		this.emailService= emailService ;
	}
	
	  @Override
	    public List<User> getUsers() {
	        return userRepository.findAll();
	    }

	    @Override
	    public User findUserByUsername(String username) {
	        return userRepository.findUserByUsername(username);
	    }

	    @Override
	    public User findUserByEmail(String email) {
	        return userRepository.findUserByEmail(email);
	    }

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userRepository.findUserByUsername(username) ;
			if (user ==null ) {
				LOGGER.error(USER_NOT_FOUND + username);
				throw new UsernameNotFoundException(USER_NOT_FOUND + username ) ;
			}else {
			 validateLoginattemps(user);
			 user.setLastLoginDateDisplay(user.getLastLoginDate());	
			 user.setLastLoginDate(new Date());
			 userRepository.save(user);
			 UserPrincipal userPricipal = new UserPrincipal(user) ;
			 LOGGER.info(FOUND_USER_BY_USERNAME + username);
			 return userPricipal;
			 
			}		
		}

		private void validateLoginattemps(User user)  {
			if (user.isNotLocked()) {
				if(loginAttemptService.hasExceededMaxAttemps(user.getUsername())) {
					user.setNotLocked(false);
				}else {
					user.setNotLocked(true);
				}
			}else {
				loginAttemptService.removeUserFromLoginAttemptCache(user.getUsername());
			}
		}

		@Override
		public User register(String firstName, String lastName, String username, String email) throws UsernameExistException, EmailExistException {
			validateNewUsernameAndEmail(StringUtils.EMPTY, username , email);
			User user = new User() ;
			user.setUserId(generateUserId());
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setEmail(email);
			user.setJoinDate(new Date());
			user.setActive(true);
			user.setNotLocked(true);
			user.setRole(ROLE_USER.name());
			user.setProfileImageUrl(getTemporaryProfileImageUrl(username));
			user.setAuthorities(ROLE_USER.getAuthorities());
			String password = generatePassword() ;
			user.setPassword(encodePassword(password));
			userRepository.save(user);
			LOGGER.info("created new password : " + password );
			emailService.sendNewPasswordEmail(firstName,username, password, email);
			return user;
		}

		
		@Override
		public User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNotLoked, boolean isActive, MultipartFile profileImage) throws UsernameExistException, EmailExistException, IOException {
			validateNewUsernameAndEmail( null  , username, email) ;
			User user = new User() ;
			String password = generatePassword() ;
			user.setPassword(encodePassword(password));
			user.setUserId(generateUserId());
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setEmail(email);
			user.setJoinDate(new Date());
			user.setActive(true);
			user.setNotLocked(true);
			user.setRole(getRoleEnumName(role).name());
			user.setAuthorities(getRoleEnumName(role).getAuthorities());
			user.setProfileImageUrl(getTemporaryProfileImageUrl(username));
			saveProfileImage(user , profileImage) ;
			userRepository.save(user);
			emailService.sendNewPasswordEmail(firstName,username, password, email);
			return user;
		}




		@Override
		public User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role,
				boolean isNotLoked, boolean isActive, MultipartFile profileImage) throws UsernameExistException, EmailExistException , IOException {
			
			User currentUser = validateNewUsernameAndEmail( currentUsername  , newUsername, newEmail) ;
			currentUser.setFirstName(newFirstName);
			currentUser.setLastName(newLastName);
			currentUser.setUsername(newUsername);
			currentUser.setEmail(newEmail);
			currentUser.setJoinDate(new Date());
			currentUser.setActive(isActive);
			currentUser.setNotLocked(isNotLoked);
			currentUser.setRole(getRoleEnumName(role).name());
			currentUser.setAuthorities(getRoleEnumName(role).getAuthorities());
			userRepository.save(currentUser);
			saveProfileImage(currentUser , profileImage) ;
			return currentUser;
			
			
		}


		@Override
		public void deleteUser(long id) {
			userRepository.deleteById(id);
		}


		@Override
		public void resetPassword(String email) throws EmailNotFoundException {
			User user = findUserByEmail(email);
			if (user==null) {
				throw new EmailNotFoundException(NO_USER_FOUND_BY_EMAIL + email );			
			}
			String password = generatePassword();
			user.setPassword(encodePassword(password));
			userRepository.save(user) ;
			LOGGER.info("this is the new password : " + password);  // delete this line 
			emailService.sendNewPasswordEmail(user.getFirstName(), password, email, user.getUsername());
		}


		@Override
		public User updateProfileImage(String username, MultipartFile profileImage) throws UsernameExistException, EmailExistException, IOException {	
			User user = validateNewUsernameAndEmail( username  , null , null) ;
			saveProfileImage(user , profileImage) ;
			return user;
		}
			
		
		private void saveProfileImage(User user, MultipartFile profileImage) throws IOException {
			if (profileImage != null) {
				Path userFolder = Paths.get(USER_FOLDER + user.getUsername()).toAbsolutePath().normalize();
				if ( !Files.exists(userFolder)){
					Files.createDirectories(userFolder);	
					LOGGER.info(DIRECTORY_CREATED + userFolder);
				}
				Files.deleteIfExists(Paths.get(USER_FOLDER + user.getUsername() + DOT + JPG_EXTENSION ));
				Files.copy(profileImage.getInputStream(),userFolder.resolve(user.getUsername()+ DOT + JPG_EXTENSION) ,REPLACE_EXISTING );
				user.setProfileImageUrl(setProfileImage(user.getUsername()));
				userRepository.save(user) ;
				LOGGER.info(FILE_SAVED_IN_FILE_SYSTEM + profileImage.getOriginalFilename());
			}
		}

		private String setProfileImage(String username) {
			return ServletUriComponentsBuilder.fromCurrentContextPath().path(USER_IMAGE_PATH + username + FORWARD_SLASH 
					+ username +DOT + JPG_EXTENSION).toUriString();
		}

				
		private Role getRoleEnumName(String role) {
			return Role.valueOf(role.toUpperCase());
		}

		
		private String generateUserId() {
			return RandomStringUtils.randomNumeric(10);
		}
		
		private String generatePassword() {
			return RandomStringUtils.randomAlphabetic(10);
		}
		
		private String encodePassword(String password) {
			return passwordEncoder.encode(password);
		}
		
		private String getTemporaryProfileImageUrl(String username) {
			return ServletUriComponentsBuilder.fromCurrentContextPath().path(DEFAULT_USER_IMAGE_PATH + username).toUriString();
		}

		

		private User validateNewUsernameAndEmail(String currentUsername , String newUsername , String newEmail) throws UsernameExistException, EmailExistException {
			User userByUsername = findUserByUsername(newUsername) ;
			User userByEmail = findUserByEmail(newEmail) ;
			User userByNewEmail = findUserByEmail(newEmail) ;
			if (StringUtils.isNotBlank(currentUsername)) {
				User currentUser = findUserByUsername(currentUsername);
				User userByNewUsername = findUserByUsername(newUsername) ;
				if(currentUser== null ) {
					throw new UsernameNotFoundException(USER_NOT_FOUND + currentUser);
				}
				if (userByNewUsername != null && !currentUser.getId().equals(userByNewUsername.getId())) {
					throw new UsernameExistException(USERNAME_ALREADY_EXISTS) ;
				}
				if (userByNewEmail != null && !currentUser.getId().equals(userByNewEmail.getId())) {
					throw new EmailExistException(EMAIL_ALREADY_EXISTS) ;
				}
				return currentUser ;
			}else {
				if (userByUsername != null ) {
					throw new UsernameExistException(USERNAME_ALREADY_EXISTS) ;
				}
				if (userByEmail != null) {
					throw new EmailExistException(EMAIL_ALREADY_EXISTS) ;
				}
				return null ;
			
			}
			
		}





}
