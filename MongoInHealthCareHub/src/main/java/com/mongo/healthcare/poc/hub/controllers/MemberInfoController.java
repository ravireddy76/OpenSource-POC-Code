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
@RequestMapping("/memberinfo")
public class MemberInfoController {
	private static final Logger logger = LoggerFactory.getLogger(MemberInfoController.class);
	
	@Resource(name = "serviceHandler")
	private ServiceHandler serviceHandler;
	
	
	/**
	 * Method to show landing view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/medications", method = RequestMethod.GET)
	public String getProfilePage() {
		logger.debug("Received request to show AJAX, provider reward page");
		return "medications";
	}



	/**
	 * Method to show landing view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public String getDoctorPage() {
		logger.debug("Received request to show AJAX, doctor reward page");
		return "doctorOffer";
	}
	
	
	/**
	 * Method to show landing view using AJAX
	 * 
	 * @return {@link String}
	 */
	@RequestMapping(value = "/offersNow", method = RequestMethod.GET)
	public String getOffersNowPage() {
		logger.debug("Received request to show AJAX, Offers Now page");
		return "offersNow";
	}
	
	
	/**
	 * Method to handle medication usage by medication name.
	 * 
	 * @param medicationName
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/medicationUsage/{medicationName}", method = RequestMethod.GET)
	public @ResponseBody String memberDashBoard(@PathVariable String medicationName, Model model, HttpServletRequest request) {
		logger.debug("Members Information using medication name..");
		ResponseEntity<String> res = null;
		String jsonResponse = null;

		try {
				String dashBoardEndPoint = ServiceEndPoints.GET_MEDICATION_USAGE_DATA_ANALYTICS+medicationName;
				res = serviceHandler.serviceResponse(dashBoardEndPoint, "");
				
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
	 * Method to get the json service response for provider Details by providerId
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/providerDetails/{providerId}", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public @ResponseBody String getProviderById(@PathVariable String providerId, Model model, HttpServletRequest request) {

		ResponseEntity<String> res = null;
		String jsonResponse = null;

		try {
			String providerEndPoint = ServiceEndPoints.GET_PROVIDERS_BY_ID_END_POINT + providerId;
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
	 * Method to get the json service response for provider Activity Details by providerType
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/providerActivityDetails/{providerType}", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public @ResponseBody String getProviderByType(@PathVariable String providerType, Model model, HttpServletRequest request) {

		ResponseEntity<String> res = null;
		String jsonResponse = null;

		try {
			String providerEndPoint = ServiceEndPoints.GET_PROVIDERS_BY_TYPE_END_POINT + providerType;
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
	 * Method to get the json service response for login user
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/allproviderInfo", method = RequestMethod.GET)
	public @ResponseBody ControllerResponse getAllProviders(@RequestBody String loginJson, 
			Model model, HttpServletRequest request) {
		
		ControllerResponse controllerResponse = new ControllerResponse();
		ResponseEntity<String> res = null;
		
		try {
			
			res = serviceHandler.serviceResponsePost(ServiceEndPoints.GET_ALL_PROVIDERS_END_POINT, loginJson, "");
			if(res.getStatusCode() == HttpStatus.OK && !res.getBody().equalsIgnoreCase("null"))
			{
				HttpSession session = request.getSession();
				session.setAttribute(MhcHubUtils.LOGGED_IN_USER, res.getBody());
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
		}
		return controllerResponse;
	}
	
	
	/**
	 * Method to get all doctors information.
	 * 
	 * @param model
	 * @return {@link String}
	 */
	@RequestMapping(value = "/allDoctorsInfo", method = RequestMethod.GET)
	public @ResponseBody String getAllDoctors(Model model) {
		String serviceResponse = null;
		
		try{
			serviceResponse = serviceHandler.serviceResponse(ServiceEndPoints.GET_ALL_DOCTORS_END_POINT);
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		
		System.out.println("Service Response............");
		System.out.println("--------------------------------");
		System.out.println(serviceResponse);
		return serviceResponse;
	}
	
}
	