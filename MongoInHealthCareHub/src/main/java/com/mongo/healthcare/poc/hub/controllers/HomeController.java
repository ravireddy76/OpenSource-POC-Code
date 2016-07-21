package com.mongo.healthcare.poc.hub.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/home")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name = "serviceHandler")
	private ServiceHandler serviceHandler;
	
	/**
	 * Method to show landing view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public String getLoginPage() {
		logger.debug("Received request to show AJAX, landing page");
		return "landing";
	}
	
	/**
	 * Method to get the json service response for login user
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ControllerResponse getUserByLogin(@RequestBody String loginJson, 
			Model model, HttpServletRequest request) {		
		ControllerResponse controllerResponse = new ControllerResponse();	
		
		try {
			Map<String,String> loginMap = loginInfo(loginJson);

			if (loginMap.get("email").equalsIgnoreCase("appDemo@demo.com")
					&& loginMap.get("password").equals("demoTest")) {
				controllerResponse.setStatus(true);
				controllerResponse.setStatusCode(HttpStatus.OK);
				controllerResponse.setResponseText(HttpStatus.OK.getReasonPhrase());
			} else {
				controllerResponse.setStatus(false);
				controllerResponse.setStatusCode(HttpStatus.NOT_FOUND);
				controllerResponse.setResponseText(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return controllerResponse;
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ControllerResponse createUser(@RequestBody String jsonData,
			Model model, HttpServletRequest request) {

		ControllerResponse controllerResponse = new ControllerResponse();
		ResponseEntity<String> res = null;
		
		try {

			res =  serviceHandler.serviceResponsePost(ServiceEndPoints.CREATE_USER_LOGIN_END_POINT, jsonData,"");			
			if(res.getStatusCode() == HttpStatus.OK && !res.getBody().equalsIgnoreCase("null")) {				
				HttpSession session = request.getSession();
				session.setAttribute(MhcHubUtils.LOGGED_IN_USER, res.getBody());
				controllerResponse.setStatus(true);
				controllerResponse.setStatusCode(HttpStatus.OK);
				controllerResponse.setResponseText(HttpStatus.OK
						.getReasonPhrase());
			} else {
				controllerResponse.setStatus(false);
				controllerResponse.setStatusCode(HttpStatus.NOT_FOUND);
				controllerResponse.setResponseText(HttpStatus.NOT_FOUND
						.getReasonPhrase());
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			controllerResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			controllerResponse.setResponseText(ex.getMessage());
			controllerResponse.setStatus(false);
		}

		return controllerResponse;
	}
	
	/**
	 * Method to logout user
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpServletRequest request) {
		logger.debug("Received request to logout user.");
		
		HttpSession session = request.getSession();

		if (!session.isNew()) {
		    session.invalidate();
		    session = request.getSession();
		}
		
		//Clear current session and redirect user to landing page.
		return "landing";
	}
	
	/**
	 * Method to show password recovery view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/recoverPassword", method = RequestMethod.GET)
	public String getPasswordRecoveryPage() {
		logger.debug("Received request to show AJAX, password recovery token page");
		return "recoverPassword";
	}
	
	/**
	 * Method to show password recovery view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String getPasswordRecoveryResetPage() {
		logger.debug("Received request to show AJAX, password recovery reset page");
		return "resetPassword";
	}
	
	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ControllerResponse contactUs(@RequestBody String jsonData,
			Model model, HttpServletRequest request) {

		ControllerResponse controllerResponse = new ControllerResponse();
		
		try {
			
			serviceHandler.serviceResponsePost(ServiceEndPoints.CONTACT_US_END_POINT, jsonData,"");			
			
			controllerResponse.setStatus(true);
			controllerResponse.setStatusCode(HttpStatus.OK);
			controllerResponse.setResponseText(HttpStatus.OK.getReasonPhrase());
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			controllerResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			controllerResponse.setResponseText(ex.getMessage());
			controllerResponse.setStatus(false);
		}

		return controllerResponse;
	}
	
	/**
	 * Method to show landing view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/headerInfo", method = RequestMethod.GET)
	public @ResponseBody String getHeaderInfo(HttpServletRequest request) {
		logger.debug("Received request to show AJAX, header section info");
		
		String serviceResponse = "";
		try {
			HttpSession session = request.getSession();
			Integer unreadMessageNum = (Integer) session.getAttribute(MhcHubUtils.NUMBER_OF_UNREAD_MESSAGE);
			JSONObject userProfile = MhcHubUtils.getJsonResponseObject(request);
			userProfile.append("numberOfUnreadMessages", unreadMessageNum);
			serviceResponse = userProfile.toString();
		} catch (Exception ex) {
		}
		
		return serviceResponse;
	}
	
	/**
	 * Method to raise the request to reset the password by using user email
	 * information
	 * 
	 * @param pwdRecoveryJson
	 * @param model
	 * @param request
	 * @return {@link ControllerResponse}
	 */
	@RequestMapping(value = "/recoverPassword", method = RequestMethod.POST)
	public @ResponseBody
	ControllerResponse recoverPassword(@RequestBody String pwdRecoveryJson,
			Model model, HttpServletRequest request) {
		
		ControllerResponse controllerResponse = new ControllerResponse();		
		ResponseEntity<String> response = null;

		try {

			response = serviceHandler.serviceResponsePost(ServiceEndPoints.PASSWORD_RECOVERY_AND_RESET,
					pwdRecoveryJson, "");

			if (response.getStatusCode() == HttpStatus.OK
					&& !response.getBody().equalsIgnoreCase("null")) {
				controllerResponse.setStatus(true);
				controllerResponse.setStatusCode(HttpStatus.OK);
				controllerResponse.setResponseText(response.getBody());
			} else if(response.getBody() == null){
				controllerResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
				controllerResponse.setResponseText(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
				controllerResponse.setStatus(false);
			}else {
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
	
	/**
	 * Method to reset the password with new password and user email information
	 * 
	 * @param jsonData
	 * @param model
	 * @param response
	 * @return {@link ControllerResponse}
	 * @throws Exception
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.PUT)
	public @ResponseBody ControllerResponse updateMasterStep(@RequestBody String passwordResetJson,
			Model model, HttpServletRequest request) throws Exception {
		logger.debug("Received request for update ");

		ControllerResponse controllerResponse = new ControllerResponse();		
		try {
				serviceHandler.serviceResponsePut(ServiceEndPoints.PASSWORD_RECOVERY_AND_RESET, passwordResetJson);
				controllerResponse.setStatus(true);
				controllerResponse.setStatusCode(HttpStatus.OK);
				controllerResponse.setResponseText(HttpStatus.OK.getReasonPhrase());			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			controllerResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			controllerResponse.setResponseText(ex.getMessage());
			controllerResponse.setStatus(false);
		}

		return controllerResponse;
	}
	
	/**
	 * Method to show under construction view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/underconstruction", method = RequestMethod.GET)
	public String geUnderConstructionPage() {
		logger.debug("Received request to show AJAX, underconstruction page");
		return "underconstruction";
	}
	
	
	/**
	 * Method to get login information to validate.
	 * 
	 * @param jsonInput
	 * @return Map
	 */
	private Map<String,String> loginInfo(String jsonInput){
		Map<String,String> loginInputMap = new HashMap<String,String>();
		JSONObject jsonObj = new JSONObject(jsonInput);
		String email = jsonObj.getString("email");
		String password = jsonObj.getString("password");
		loginInputMap.put("email", email);
		loginInputMap.put("password",password);
		return loginInputMap;
	}
	
}
