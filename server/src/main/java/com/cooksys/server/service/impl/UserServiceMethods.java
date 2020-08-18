package com.cooksys.server.service.impl;

import com.cooksys.server.entity.Credentials;
import com.cooksys.server.entity.User;
import com.cooksys.server.errorhandling.RequiredFieldsMissingException;
import com.cooksys.server.errorhandling.UserDoesNotMatchCredentialsException;
import com.cooksys.server.errorhandling.UserNotFoundException;

/**
 * UserServiceMethods
 */
public class UserServiceMethods {

    public boolean verifyUser(User user) {
		if (user == null) {
			throw new UserNotFoundException();
		}
		if (user.getMetadata().getDeletedFlag()) {
			throw new UserNotFoundException("The User has been deleted");
		}
		return true;
    }
    
    public boolean checkRequiredFields(User user) {
		if (user.getCredentials().getUsername().length() == 0) {
			throw new RequiredFieldsMissingException("The Username is Empty. Please input a username");
        }
        else if ( user.getCredentials().getPassword().length() == 0) {
            throw new RequiredFieldsMissingException("The password is Empty. Please input a password");

        }
		return true;
    }
    
    public void checkUserCredentials(User user, Credentials credentials) {
		if (credentials == null) {
            throw new RequiredFieldsMissingException("You need to include the Credentials, which includes the username and password");
		}
		if (user == null) {
            throw new UserNotFoundException();
		}
		if (!credentials.getPassword().equals(user.getCredentials().getPassword())) {
            throw new UserDoesNotMatchCredentialsException();
		}
		if (user.getMetadata().getDeletedFlag()){
			throw new UserNotFoundException("The User has been deleted");
		}
		return ;
    }
}