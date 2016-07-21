package com.mongo.healthcare.poc.hub.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mongo.healthcare.poc.hub.utils.ControllerResponse;
import com.mongo.healthcare.poc.hub.utils.MhcHubUtils;
import com.mongo.healthcare.poc.hub.utils.ServiceEndPoints;
import com.mongo.healthcare.poc.hub.utils.ServiceHandler;

@Controller
@RequestMapping("/inboxmessage")
public class MessageController {
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Resource(name = "serviceHandler")
	private ServiceHandler serviceHandler;
	
	/**
	 * Method to show message view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/allmessages", method = RequestMethod.GET)
	public String getMessagePage() {
		logger.debug("Received request to show AJAX, message page");
		return "usermessage";
	}
	
	/**
	 * Method to show message details view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/messagedetails", method = RequestMethod.GET)
	public String getMessageDetailsPage() {
		logger.debug("Received request to show AJAX, message page");
		return "messagedetails";
	}
	
	/**
	 * Method to get the json service response for provider Details by providerId
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/details/{messageId}", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public @ResponseBody String getMessageById(@PathVariable String messageId, Model model, HttpServletRequest request) {

		ResponseEntity<String> res = null;
		String jsonResponse = null;

		try {
			String providerEndPoint = ServiceEndPoints.MESSAGE_BY_ID_END_POINT + messageId;
			res =  serviceHandler.serviceResponse(providerEndPoint,"");			
			if (res.getStatusCode() == HttpStatus.OK
					&& !res.getBody().equalsIgnoreCase("null")) {
				jsonResponse = res.getBody();
			} else {
				System.out.println("status" + res.getStatusCode());
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return jsonResponse;
	}
	
	/**
	 * Method to get the json service response for customer message by user profile id
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/unread", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public @ResponseBody String getUnreadMessages(Model model, HttpServletRequest request) {

		ResponseEntity<String> res = null;
		String jsonResponse = null;

		try {
			Integer memberId = MhcHubUtils.getActiveMemberId(request);
			String messageEndPoint = ServiceEndPoints.UNREAD_MESSAGE_END_POINT + memberId; 
			res =  serviceHandler.serviceResponse(messageEndPoint,"");			
			if (res.getStatusCode() == HttpStatus.OK
					&& !res.getBody().equalsIgnoreCase("null")) {
				jsonResponse = res.getBody();
			} else {
				System.out.println("status" + res.getStatusCode());
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return jsonResponse;
	}
	
	/**
	 * Method to get the json service response for customer message by user profile id
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/viewed", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public @ResponseBody String getViewedMessages(Model model, HttpServletRequest request) {

		ResponseEntity<String> res = null;
		String jsonResponse = null;

		try {
			Integer memberId = MhcHubUtils.getActiveMemberId(request);
			String messageEndPoint = ServiceEndPoints.VIEWED_MESSAGE_END_POINT + memberId;
			res =  serviceHandler.serviceResponse(messageEndPoint,"");			
			if (res.getStatusCode() == HttpStatus.OK
					&& !res.getBody().equalsIgnoreCase("null")) {
				jsonResponse = res.getBody();
			} else {
				System.out.println("status" + res.getStatusCode());
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return jsonResponse;
	}
	
	@RequestMapping(value = "/memberviewed", method = RequestMethod.POST)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ControllerResponse createMemberViewedMessage(@RequestBody String jsonData,
			Model model, HttpServletRequest request) {

		ControllerResponse controllerResponse = new ControllerResponse();
		ResponseEntity<String> res = null;
		
		try {

			res =  serviceHandler.serviceResponsePost(ServiceEndPoints.CREATE_MEMBER_VIEWED_MESSAGE_END_POINT, jsonData,"");			
			
			if(res.getStatusCode() == HttpStatus.OK)
			{
				HttpSession session = request.getSession();
				Integer unreadMessageNum = (Integer) session.getAttribute(MhcHubUtils.NUMBER_OF_UNREAD_MESSAGE);
				if(unreadMessageNum > 0){
					session.setAttribute(MhcHubUtils.NUMBER_OF_UNREAD_MESSAGE, --unreadMessageNum);
				}
				
				controllerResponse.setStatus(true);
				controllerResponse.setStatusCode(HttpStatus.OK);
				controllerResponse.setResponseText(HttpStatus.OK.getReasonPhrase());
			}
			else
			{
				controllerResponse.setStatus(false);
				controllerResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
				controllerResponse.setResponseText(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
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
