package com.op.login.service;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookServiceImp implements FacebookService {

	private String facebookId = "759618637851136";
	private String facebooksecretId="e1fca8d7a1d579fd4f35edf89f9cf3fd";
	
	private FacebookConnectionFactory createFacebookconnection() {
		return new FacebookConnectionFactory(facebookId, facebooksecretId);
		
	}
	@Override
	public String facebooklogin() {
		OAuth2Parameters parameters =new OAuth2Parameters();
		parameters.setRedirectUri("http://localhost:8080/facebook");
		parameters.setScope("public_profile,email");
		return createFacebookconnection().getOAuthOperations().buildAuthenticateUrl(parameters);
	}
	
	
	@Override
	public String getFacebookAccessToken(String code) {
		// TODO Auto-generated method stub
		return createFacebookconnection().getOAuthOperations().exchangeForAccess(code,"http://localhost:8080/facebook",null).getAccessToken();
	}
	
	@Override
	public User getfacebookprofiledata(String accessToken) {
		Facebook facebook = new FacebookTemplate(accessToken);
		String[] fields = {"id","first_name","last_name","cover","email"};
				return facebook.fetchObject("me", User.class,fields);
	}

}
