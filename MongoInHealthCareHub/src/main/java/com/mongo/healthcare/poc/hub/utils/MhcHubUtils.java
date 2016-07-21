package com.mongo.healthcare.poc.hub.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;




/**
 * MhcHubUtils class is a re usable object which consists common methods
 * with in the enterprise application.
 * 
 * @author rreddy [{@link MailTo rreddy@htconsultancy.us}]
 * @Date-Time 11:35:17 December 08, 2013 CST
 * @CopyRight (C) All rights reserved to Partnera. It's Illegal to reproduce this code.
 */
public class MhcHubUtils {
	
	/* Property for logged in user key.*/
	public static String LOGGED_IN_USER = "LoggedInUser";
	
	/* Property for logged in user key.*/
	public static String NUMBER_OF_UNREAD_MESSAGE = "NumberOfUnreadMessage";
	
	/**
	 * Method to get the JSON response object.
	 * 
	 * @param request
	 * @return {@link JSONObject}
	 * @throws Exception
	 */
	public static JSONObject getJsonResponseObject(HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String response = (String) session.getAttribute(LOGGED_IN_USER);
		JSONObject jsonResponse = new JSONObject(response);
		return jsonResponse;
	}
	
	/**
	 * Method to get the json service response for userId
	 * 
	 * @param model
	 * @return {@link String}
	 */
	public static Integer getUserProfileId(HttpServletRequest request){
		Integer userProfileId = 0;
		try{
		JSONObject object = getJsonResponseObject(request);
		userProfileId = (Integer) object.get("userProfileIdentifier");
		
		} catch (Exception ex) {
		}
		return userProfileId;
	}
	
	/**
	 * Method to get the json service response for active member id
	 * 
	 * @param model
	 * @return {@link String}
	 */
	public static Integer getActiveMemberId(HttpServletRequest request){
		Integer memberId = 0;
		try{
			JSONObject object = getJsonResponseObject(request);
			memberId = (Integer) object.get("activeMemberIdentifier");
		
		} catch (Exception ex) {
		}
		return memberId;
	}
	
	/**
	 * Method to get the json service response for apiToken
	 * 
	 * @param model
	 * @return {@link String}
	 */
	public static String getApiToken(HttpServletRequest request)
			throws Exception {
		String apiToken = "";
		HttpSession session = request.getSession();
		String response = (String) session.getAttribute(LOGGED_IN_USER);
		JSONObject jsonResponseobject = new JSONObject(response);
		apiToken = jsonResponseobject.getString("apiToken");
		
		//TODO
		/* Get the user api token array and read the user api token object. */
		/*JSONArray userApiTokenArray = jsonResponseobject
				.getJSONArray("userApiTokens");
		JSONObject userApiTokenObject = userApiTokenArray.getJSONObject(0);
		apiToken = userApiTokenObject.getString("apiKey");*/
		
		return apiToken;
	}
	
	
	/**
	 * Method to parse the json request based on
	 * 
	 * @param jsonInput
	 * @return Map
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String,String> parseJsonRequest(String jsonInput, Map<String, String> keys){
		Map<String,String> parsedJsonMap = new HashMap<String,String>();
		JSONObject jsonObj = new JSONObject(jsonInput);
		Iterator iter = keys.entrySet().iterator();
		 
		while (iter.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iter.next();
			String parsedValue = jsonObj.getString(mapEntry.getKey().toString());
			parsedJsonMap.put(mapEntry.getKey().toString(), parsedValue);
		}
		return parsedJsonMap;
	}

}
