package com.op.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.op.login.model.UserInfo;
import com.op.login.service.FacebookService;


@Controller
public class FacebookController {
	
	@Autowired
	FacebookService facebookservice;
	@GetMapping(value="/facebooklogin")
	public RedirectView facebooklogin() {
		RedirectView redirectView =new RedirectView();
		String url=facebookservice.facebooklogin();
		System.out.println(url);
		redirectView.setUrl(url);
		return redirectView;	
	}

	@GetMapping(value="/facebook")
	public String facebook(@RequestParam("code") String code) {
		String accessToken =facebookservice.getFacebookAccessToken(code);
		return "redirect:/facebookprofiledata/"+accessToken;
	}
	
	
	@GetMapping(value="/facebookprofiledata/{accessToken:.+}")
	public String facebookprofiledata(@PathVariable String accessToken,Model model) {
		User user = facebookservice.getfacebookprofiledata(accessToken);
		UserInfo info = new UserInfo(user.getFirstName(),user.getLastName(),user.getCover().getSource());
		model.addAttribute("user",info);
		return "view/userprofile";
	}
}
