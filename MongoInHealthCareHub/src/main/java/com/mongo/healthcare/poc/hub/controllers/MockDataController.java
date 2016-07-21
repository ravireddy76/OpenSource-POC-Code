package com.mongo.healthcare.poc.hub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mockdata")
public class MockDataController {
	 private static final Logger logger = LoggerFactory.getLogger(MockDataController.class);
			 
			 
	@RequestMapping(value = "/memberEarnedRewards", method = RequestMethod.GET)
    public @ResponseBody
    String memberEarnedRewards(Model model) {
            logger.debug("Received request for DashBoard Member Earned Rewards..");
            String serviceResponse;

            try {
                    serviceResponse = buildMembersEarnedRewardsJson();
            } catch (Exception e) {
                    logger.error(e.getMessage());
                    serviceResponse = e.getMessage();
            }

            return serviceResponse;
    }
	
	
	@RequestMapping(value = "/memberRewardActivities", method = RequestMethod.GET)
    public @ResponseBody
    String memberRewardsActivites(Model model) {
            logger.debug("Received request for DashBoard Member Rewards Activites..");
            String serviceResponse;

            try {
                    serviceResponse = buildRewardsActivitiesJson();
            } catch (Exception e) {
                    logger.error(e.getMessage());
                    serviceResponse = e.getMessage();
            }

            return serviceResponse;
    }
	
	
	
	/**
	 * Method to build members earnes rewards json
	 * 
	 * @return {@link String}
	 */
	private String buildMembersEarnedRewardsJson() {
		String rewardsJson = null;
		rewardsJson = "[{\"cLabelName\":\"availableRewards\",\"cLabelValue\":650},{"+
                "\"cLabelName\":\"earnedRewards\",\"cLabelValue\":350}]";
		return rewardsJson;
	}
	
	
	
	private String buildRewardsActivitiesJson(){
		String rewardsActivitiesJson = null;
		
		rewardsActivitiesJson = "["
				+ "{"
				+ "\"rewardValue\": 200,"
				+ "\"healthActivites\":\"Annual Physical Exam\","
				+ "\"activityStatus\":\"Completed\","
				+ "\"earnedRewards\":200 },"
				+"{\"rewardValue\": 200,"
				+ "\"healthActivites\":\"Weight Management\","
				+ "\"activityStatus\":\"Completed\","
				+ "\"earnedRewards\":90},"
				+ "{\"rewardValue\": 300,"
				+ "\"healthActivites\":\"Stress Management\","
				+ "\"activityStatus\":\"Completed Between 10/01/2013 - 12/31/2013\","
				+ "\"earnedRewards\":100}"
				+ "]";
		
		return rewardsActivitiesJson;
	}

}
