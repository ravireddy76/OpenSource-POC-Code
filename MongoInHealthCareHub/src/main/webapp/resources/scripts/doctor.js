/******************************************************************************************************
 * Doctor java script activities functions to handle event actions in doctors page.
 *        
 * @author rreddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 13:22:12 April 08, 2014 CST
 * @CopyRight (C) All rights reserved to Partnera Inc. It's Illegal to reproduce this code.
 ******************************************************************************************************/

/**
 * Function to build the earn rewards chart for the given member
 * @param sourceUrl
 */ 
$(document).ready(function() {
	$("#doctorOffer").addClass('active');
	$("#hdRewardNetwork").addClass('active');
	
	var theme = "ui-overcast";
	var allDoctorsUrl = "/MongoInHealthCareHub/memberinfo/allDoctorsInfo";
	var doctorActivationCounter = 0;
	var selectedDoctorsArray = [];
	
	/* Doctors activation button */
	$("#activateBtnId").jqxButton(
		{ width: 90,theme: "black"}
	);
	
	/* Get Boo Template Information.*/
    var doctorsDataSource =
    {
	    datatype: "json",
		datafields : [
			{name: 'providerName'}, 						
			{name: 'businessAddress'},					
			{name: 'nationalProviderIdentifier'},
			{name: 'practicePhone'}
		],
		id : 'providerIdentifier',
		url: allDoctorsUrl,
		type : "GET"
	}; 
	
    
    /* Bind the source to data adapter.*/
    var doctorsDataAdapter = flattenDataSourceAdapter(doctorsDataSource);
    //var doctorsDataAdapter = new $.jqx.dataAdapter(doctorsDataSource);
    
    /* Doctors Grid.*/
    $("#doctorsGrid").jqxGrid({
  	   	 width: 743, 
		 height: 600,
         source: doctorsDataAdapter,
         theme: theme,
         pageable: true,
         autoheight: true,
         sortable: true,
         columnsresize: true,
         selectionmode: 'multiplerows',
         columns: [ 
 		  { text: 'Name', datafield: 'providerName', width: 110 },
          { text: 'Address', datafield: 'businessAddress', width: 250 },
          { text: 'Practice', datafield: 'nationalProviderIdentifier', width: 150, sortable: false  },              
          { text: 'Reward', datafield: 'practicePhone', width: 110 },
          { text: 'Activate', datafield: 'activate', minwidth: 80, sortable: false },                 	  
      ]
    });
    
    
    /* Handling the row selection event in the doctors grid.*/  
    $("#doctorsGrid").bind('rowselect', function (event) {
 	   	 var rowindex = event.args.rowindex;
	   	 selectedDoctorsArray.push(rowindex);
	   	 doctorActivationCounter = doctorActivationCounter+1;
	   	 
	   	if(doctorActivationCounter > 0 && doctorActivationCounter < 6){
    		for ( var index = 0; index < selectedDoctorsArray.length; index = index+1) {
    			
    			//<p style="color:red; background-color: #33FF99">
    			//<p style='color:red; background-color: #33FF99'><b>Activated</b></p>
    			//<font color='red'><b>Activated</b></font>
    			$("#doctorsGrid").jqxGrid("setcellvalue", selectedDoctorsArray[index], 'activate', "<font color='red'><b>Selected</b></font>");
    		}
    	}else if(doctorActivationCounter < 0 || doctorActivationCounter > 5){
    		alertMessageWindow("Can't select more than 5 activations..");
    	}
    });
    
    /* Handling the row unselect event in the doctors grid.*/
    $("#doctorsGrid").bind('rowunselect', function (event) {
    	var indexToRemove = event.args.rowindex;
    	$("#doctorsGrid").jqxGrid("setcellvalue", indexToRemove, 'activate', '');
	   	selectedDoctorsArray.splice($.inArray(indexToRemove, selectedDoctorsArray),1);
    	doctorActivationCounter = doctorActivationCounter-1;
    });
    
    /* Handle the EDIT button action event.**/
//    $("#activateBtnId").click(function (event) {
//  		
//        /* Validate number of doctor activations.*/
//    	if(doctorActivationCounter > 0 && doctorActivationCounter < 6){
//    		for ( var index = 0; index < selectedDoctorsArray.length; index = index+1) {
//    			$("#doctorsGrid").jqxGrid("setcellvalue", selectedDoctorsArray[index], 'activate', "<font color='red'><b>Activated</b></font>");
//    		}
//    	}else if(doctorActivationCounter < 0 || doctorActivationCounter > 5){
//    		alertMessageWindow("Can't select more than 5 activations..");
//    	}else if(doctorActivationCounter == 0){
//    		alertMessageWindow("Need to select at least 1 to Maximum 5..");
//    	}
//    });
    
});


/* Function to flatten the JSON data. */
function flattenDataSourceAdapter(dataSource) {
	var dataSourceAdapter = new $.jqx.dataAdapter(dataSource, {
		processData : function(data) {
			data.style = "full";
		},
		beforeLoadComplete : function(records) {
			var data = new Array();
			for (var i = 0; i < records.length; i++) {
				if (records[i].systemFlag != 1) {
					data.push(records[i]);
				}
			}
			return data;
		},
		downloadComplete : function(edata, textStatus, jqXHR) {
			for ( var key in edata) {
				if (edata.hasOwnProperty(key)) {
					edata[key] = dataparserutil.flattenJson(edata[key]);
				}
			}

			jsondata = edata;
			return edata;
		},
		loadComplete : function() {
		},
		loadError : function(jqXHR, status, error) {
			jAlert(jqXHR.responseText);
		}
	});
	return dataSourceAdapter;
}


/* Alert message window*/
function alertMessageWindow(alertMessage){
	popupWindow();
	$("#alertWindowId").jqxWindow("title","Warning Message");
	$("#alertWindowId").jqxWindow("content", "<font-style:oblique>"+alertMessage+"</font>");
	$("#alertWindowId").jqxWindow("open");
}


/* Creating the pop up window */
function popupWindow() {
    $('#alertWindowId').jqxWindow({
        showCollapseButton: false, 
        height: 90, 
        width: 300,
        theme: "orange"
    });
}