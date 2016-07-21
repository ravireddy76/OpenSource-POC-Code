package com.mongo.healthcare.poc.hub.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mongo.healthcare.poc.hub.utils.ControllerResponse;
import com.mongo.healthcare.poc.hub.utils.MhcHubUtils;
import com.mongo.healthcare.poc.hub.utils.ServiceEndPoints;
import com.mongo.healthcare.poc.hub.utils.ServiceHandler;


@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "serviceHandler")
	private ServiceHandler serviceHandler;
	
	/**
	 * Method to show landing view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getProfilePage() {
		logger.debug("Received request to show AJAX, my profile page");
		return "userProfile";
	}
	
	/**
	 * Method to show reset password view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
	public String getResetPasswordPage() {
		logger.debug("Received request to show AJAX, my profile page");
		return "updatePassword";
	}
	
	/**
	 * Method to show landing view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/profileInfo", method = RequestMethod.GET)
	public @ResponseBody String getProfilePageInfo(HttpServletRequest request) {
		logger.debug("Received request to show AJAX, my profile page info");
		
		String serviceResponse = "";
		
		HttpSession session = request.getSession();
		Object userProfile = session.getAttribute(MhcHubUtils.LOGGED_IN_USER);
		if(userProfile != null){
			serviceResponse = (String)userProfile;
		}
		
		return serviceResponse;
	}
	
	@RequestMapping(value = "/profileUpdate", method = RequestMethod.PUT)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ControllerResponse createUser(@RequestBody String jsonData,
			HttpServletRequest request) {

		ControllerResponse controllerResponse = new ControllerResponse();
		ResponseEntity<String> res = null;
		
		try {

			res =  serviceHandler.serviceResponsePut(ServiceEndPoints.CREATE_USER_UPDATE_END_POINT, jsonData,"");			
			
			if(res.getStatusCode() == HttpStatus.OK)
			{
				Integer userProfileId = MhcHubUtils.getUserProfileId(request);
				String profileEndPoint = ServiceEndPoints.GET_USER_PROFILE_END_POINT + userProfileId;
				res =  serviceHandler.serviceResponse(profileEndPoint, "");			

				if (res.getStatusCode() == HttpStatus.OK
						&& !res.getBody().equalsIgnoreCase("null")) {
					HttpSession session = request.getSession();
					session.setAttribute(MhcHubUtils.LOGGED_IN_USER, res.getBody());
				} 
				controllerResponse.setStatus(true);
				controllerResponse.setStatusCode(HttpStatus.OK);
				controllerResponse.setResponseText(HttpStatus.OK.getReasonPhrase());
			}
			else
			{
				controllerResponse.setStatus(false);
				controllerResponse.setStatusCode(HttpStatus.NOT_FOUND);
				controllerResponse.setResponseText(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			controllerResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			controllerResponse.setResponseText(ex.getMessage());
			controllerResponse.setStatus(false);
		}

		return controllerResponse;
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ControllerResponse resetPassword(@RequestBody String jsonData,
			HttpServletRequest request) {

		ControllerResponse controllerResponse = new ControllerResponse();
		ResponseEntity<String> res = null;
		
		try {
			res =  serviceHandler.serviceResponsePost(ServiceEndPoints.RESET_PASSWORD_END_POINT, jsonData,"");			
			
			if(res.getStatusCode() == HttpStatus.OK)
			{
				controllerResponse.setStatus(true);
				controllerResponse.setStatusCode(HttpStatus.OK);
				controllerResponse.setResponseText(HttpStatus.OK.getReasonPhrase());
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			controllerResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			controllerResponse.setResponseText(ex.getMessage());
			controllerResponse.setStatus(false);
		}

		return controllerResponse;
	}
	
	
}