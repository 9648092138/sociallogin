package com.op.login.service;

import org.springframework.social.facebook.api.User;

public interface FacebookService {

	String facebooklogin();

	String getFacebookAccessToken(String code);

	User getfacebookprofiledata(String accessToken);

}
