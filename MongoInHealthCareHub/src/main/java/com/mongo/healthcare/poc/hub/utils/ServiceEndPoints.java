package com.mongo.healthcare.poc.hub.utils;

import java.io.Serializable;

/**
 * ServiceEndPoints class is place holder to hold the service end point as a constants.
 * with in the enterprise application.
 * 
 * @author ravi reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 11:35:17 December 08, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi POC. It's Illegal to reproduce this code.
 */
public class ServiceEndPoints implements Serializable {
	private static final long serialVersionUID = -4521595602444678651L;
	
	/* Properties for miscellaneous constants.*/
	public static final String HTTP = "http://";
	
	/* Properties for service base url */
	public static final String BASE_URL = "/MongoInHealthCare/";
	
	/* User service end points constants */
	public static final String GET_USER_LOGIN_END_POINT = BASE_URL + "user/login";
	public static final String CREATE_USER_LOGIN_END_POINT = BASE_URL + "user/signup";
	public static final String CREATE_USER_UPDATE_END_POINT = BASE_URL + "user/update";
	public static final String RESET_PASSWORD_END_POINT = BASE_URL + "user/resetPassword";
	public static final String GET_USER_PROFILE_END_POINT = BASE_URL + "user/search/byUserProfileId?userProfileId=";
	public static final String DASHBOARD_END_POINT = BASE_URL + "user/dashboard?userProfileId=";
	
	/*Contact us service end points constants*/
	public static final String CONTACT_US_END_POINT = BASE_URL + "contactus";
	
	/*Password recovery service end points constants*/
	public static final String PASSWORD_RECOVERY_AND_RESET = BASE_URL + "passwordRecovery";
	
	/* Member health data analytics service end points constants*/
	public static final String GET_MEMBER_HEALTH_DATA_ANALYTICS = BASE_URL + "analyticsdata/searchConditionCode?conditionCode=";
	public static final String GET_MEDICATION_USAGE_DATA_ANALYTICS = BASE_URL + "analyticsdata/searchByMedication?medicationName=";

	
	/* OLD service end points.*/
	public static final String UNREAD_MESSAGE_END_POINT = BASE_URL + "message/unread/byMemberId?memberId=";
	public static final String VIEWED_MESSAGE_END_POINT = BASE_URL + "message/viewed/byMemberId?memberId=";
	public static final String MESSAGE_BY_ID_END_POINT = BASE_URL + "message/details/byId?messageId=";
	public static final String CREATE_MEMBER_VIEWED_MESSAGE_END_POINT = BASE_URL + "message/memberviewed";
	public static final String GET_ALL_DOCTORS_END_POINT = BASE_URL + "provider/search/alldoctors";
	public static final String GET_ALL_PROVIDERS_END_POINT = BASE_URL + "provider/search/all";
	public static final String GET_PROVIDERS_BY_ID_END_POINT = BASE_URL + "provider/search/byId?providerId=";
	public static final String GET_PROVIDERS_BY_TYPE_END_POINT = BASE_URL + "provider/search/byType?providerType=";
}
