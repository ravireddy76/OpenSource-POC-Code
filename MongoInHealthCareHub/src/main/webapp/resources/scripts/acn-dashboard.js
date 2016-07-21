/******************************************************************************************************
 * DashBoard java script activities functions to handle event actions.
 *        
 * @author rreddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 13:22:12 December 12, 2013 CST
 * @CopyRight (C) All rights reserved to Partnera Inc. It's Illegal to reproduce this code.
 ******************************************************************************************************/

/* Global variable.*/
var memberAddress = null;


/**
 * Function to build the earn rewards chart for the given member
 * @param sourceUrl
 */ 
$(document).ready(function() {
	$("#hdDashboard").addClass('active');
	var theme = getDemoTheme();
	var memberHealthDataUrl = "/MongoInHealthCareHub/dashboard/healthDataDashBoard";
	
	/* Doctors activation button */
	$("#searchCondBtnId").jqxButton(
		{ width: 90,theme: "black"}
	);
	
//	var address = "730 South 8th Street, Minneapolis, MN 55415";
// 	paintMap(address,"member-map-canvas");
 	
//	var chartSettings = buildHealthDataAnalyticsChart(memberHealthDataUrl);
//	$('#chartHealthDataAnalyticsId').jqxChart(chartSettings);
	
});



function searchMemberConditionCodeAction(){
	var conditionCode = $("#condCodeId").val();
	var memberHealthDataUrl = "/MongoInHealthCareHub/dashboard/healthDataDashBoard/"+conditionCode;
	var chartSettings = buildHealthDataAnalyticsChart(memberHealthDataUrl);
	$('#chartHealthDataAnalyticsId').jqxChart(chartSettings);

	/* Paint the map using member address.*/
	paintMap(memberAddress,"member-map-canvas");
}


function buildHealthDataAnalyticsChart(sourceUrl) {
	/* Get the rewards mock data.*/
	var source = {
			datatype : "json",
			datafields : [ 
              {	name : 'memberName',type: 'string'}, 
              { name : 'vitalSignsCount', type: 'string'},
              { name : 'allergiesCount', type: 'string'},
              { name : 'immunizationsCount', type: 'string'},
              { name : 'planOfCaresCount', type: 'string'},
              { name : 'medicationsCount', type: 'string'},
              { name : 'proceduresCount', type: 'string'},
              { name : 'diagnosticResultsCount', type: 'string'},
              { name : 'conditionsCount', type: 'string'},
              { name : 'memberAddress', type: 'string'}
			],
			url : sourceUrl
	};

	/* Build the data-adapter to bind the data.*/
	var dataAdapter = new $.jqx.dataAdapter(source, {
		beforeLoadComplete: function (records) {
			memberAddress = records[0].memberAddress;
        },
		async : false,
		autoBind : true,
		loadError : function(xhr, status, error) {
			alert('Error loading "' + source.url + '" : ' + error);
		}
	});

	/* Build required chart settings.*/
	var settings = {
		title : "Member Helath Data Analytics",
		description : "",
		showLegend : true,
		enableAnimations : true,
		padding : {
			left : 5,
			top : 5,
			right : 5,
			bottom : 5
		},
		titlePadding : {
			left : 90,
			top : 0,
			right : 0,
			bottom : 10
		},
		source : dataAdapter,
		categoryAxis : {
			dataField : 'memberName',
			showGridLines : true
		},
		colorScheme : 'scheme04',
		seriesGroups : [ {
			type : 'column',
			columnsGapPercent : 50,
			valueAxis : {
				unitInterval : 1,
				displayValueAxis : true,
				description : 'Number of (Count)'
			},
			series : [
				 {
				dataField : 'vitalSignsCount',
				displayText : 'Vital Signs'
			}, {
				dataField : 'allergiesCount',
				displayText : 'Allergies'
			}, {
				dataField : 'immunizationsCount',
				displayText : 'Immunization'
			}, {
				dataField : 'planOfCaresCount',
				displayText : 'Plan Of Cares'
			}, {
				dataField : 'medicationsCount',
				displayText : 'Medications'
			}, {
				dataField : 'proceduresCount',
				displayText : 'Procedures'
			}, {
				dataField : 'diagnosticResultsCount',
				displayText : 'Diagnostics'
			}, {
				dataField : 'conditionsCount',
				displayText : 'Conditions'
			}
			]
		}, {
			type : 'line',
			valueAxis : {
				unitInterval : 10,
				displayValueAxis : false,
				description : ''
			},
            series: [
                 {dataField : 'conditionsCount',displayText : 'Conditions'}
            ]
		} ]
	};
	return settings;
}



/* Method to paint map for the given address address lat/long and mark google maps */
function paintMap(address,htmlElementId) {
	var geocoder = new google.maps.Geocoder();
	geocoder.geocode({'address' : address},
	function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			
			/* Create a Google Map at the latitude/longitude returned by the Geocoder.*/
			var myOptions = {
				zoom : 4,
				center : results[0].geometry.location,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
	
			var map = new google.maps.Map(document.getElementById(htmlElementId), myOptions);
	
			/* Add a marker at the address. */
			var marker = new google.maps.Marker({
				map : map,
				position : results[0].geometry.location
			});
		} else {
			try {
				console.error("Geocode was not successful for the following reason: "+ status);
			} catch (e) {}
		}
	});
}


/**
 * Function to build the members rewards activities grid.
 * 
 * @param sourceUrl
 * @param gridName
 * @param theme
 */
function buildRewardsGrid(sourceUrl, gridName, theme) {
	var dataGridId = "#" + gridName;
	var themeType = theme;

	var source =
	{
			datatype: "json",
			datafields: [
			             { name: 'rewardValue', type: 'int' },
			             { name: 'healthActivites', type: 'string' },      
			             { name: 'activityStatus', type: 'string' },
			             { name: 'earnedRewards', type: 'int' }
			             ],
			             url: sourceUrl
	};	

	var dataAdapter = new $.jqx.dataAdapter(source);
	$(dataGridId).jqxGrid(
			{
				width: 800,
				height: 600,
				source: dataAdapter,
				theme: themeType,
				columnsresize: true,
				sortable: true,
				pageable: true,
				autoheight: true,
				columns: [
				          { text: 'Reward Value', datafield: 'rewardValue', width: 120 },
				          { text: 'Health Activites', datafield: 'healthActivites', width: 160 },
				          { text: 'Activity Status', datafield: 'activityStatus', width: 400 },
				          { text: 'Earned Rewards', datafield: 'earnedRewards', width: 120 }
				          ]
			});
}