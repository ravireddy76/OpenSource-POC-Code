package com.mongo.healthcare.poc.hub.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mongo.healthcare.poc.hub.utils.ServiceEndPoints;
import com.mongo.healthcare.poc.hub.utils.ServiceHandler;


@Controller
@RequestMapping("/dashboard")
public class DashBoardController {
	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	
	@Resource(name = "serviceHandler")
	private ServiceHandler serviceHandler;
	
	
	/**
     * Method to show the relation template view using AJAX
     *
     * @return {@link String}
     */
    @RequestMapping(value = "/dbdetails", method = RequestMethod.GET)
    public String getRelationPage() {
            logger.debug("Received request to show AJAX, dashboard page");
            return "dbdetails";
    }
    
    
	@RequestMapping(value = "/healthDataDashBoard/{conditionCode}", method = RequestMethod.GET)
	public @ResponseBody String memberDashBoard(@PathVariable String conditionCode, Model model, HttpServletRequest request) {
		logger.debug("Members Information using condtion code..");
		ResponseEntity<String> res = null;
		String jsonResponse = null;

		try {
				String dashBoardEndPoint = ServiceEndPoints.GET_MEMBER_HEALTH_DATA_ANALYTICS+conditionCode;
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
	
	
	
//	@RequestMapping(value = "/membersByConditionCode", method = RequestMethod.POST)
//	public @ResponseBody String searchMembersByConditionCode(@RequestBody String requestJson, 
//			Model model, HttpServletRequest request) {
//		logger.debug("Received request for members by condition code..");
//		ResponseEntity<String> res = null;
//		String jsonResponse = null;
//
//		try {
//				Map<String, String> keys =  new HashMap<String, String>();
//				keys.put("conditionCode", "conditionCode");
//				Map<String,String> parsedJsonMap = MhcHubUtils.parseJsonRequest(requestJson, keys);
//				String conditionCode = parsedJsonMap.get("conditionCode");		
//				
//				
//				String searchMembersConditionCodeEndPoint = ServiceEndPoints.GET_MEMBER_HEALTH_DATA_ANALYTICS+conditionCode;
//				System.out.println(">>>> SearchMembersConditionCodeEndPoint == "+searchMembersConditionCodeEndPoint);
//				
//				res = serviceHandler.serviceResponse(searchMembersConditionCodeEndPoint, "");
//	
//				if (res.getStatusCode() == HttpStatus.OK
//						&& !res.getBody().equalsIgnoreCase("null")) {
//					jsonResponse = res.getBody();
//				} else {
//					System.out.println("status" + res.getStatusCode());
//				}
//		} catch (Exception ex) {
//			logger.error(ex.getMessage());
//		}
//		
//		System.out.println(jsonResponse);
//		return jsonResponse;
//	}
	
    
    /**
	 * Method to build members earns rewards json
	 * 
	 * @return {@link String}
	 */
	private String buildMembersEarnedRewardsJson() {
		String rewardsJson = null;
		rewardsJson = "[{\"cLabelName\":\"availableRewards\",\"cLabelValue\":650},{"+
                "\"cLabelName\":\"earnedRewards\",\"cLabelValue\":350},{" +
                "\"cLabelName\":\"perCompleted\",\"cLabelValue\":200}]";
		return rewardsJson;
	}
    
}
