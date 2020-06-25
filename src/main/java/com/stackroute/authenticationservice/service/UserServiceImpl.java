package com.stackroute.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.authenticationservice.domain.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException {
		
		User user = userRepository.findByUsernameAndPassword(username, password);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return user;
		
	}

}
