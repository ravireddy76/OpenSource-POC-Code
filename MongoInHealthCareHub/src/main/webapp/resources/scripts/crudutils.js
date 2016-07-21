/******************************************************************************************************
 * CRUD OPERATION Functions to handle POST/PUT/DELETE events using service end points.  
 *	
 * @author ravi reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 13:22:12 April 8, 2014 CST
 * @CopyRight (C) All rights reserved to Partnera Inc. It's Illegal to reproduce this code.
 ******************************************************************************************************/
 
/**
 * Function to handle the add process in the UI by invoking
 * POST(Create/Add) service operation. 
 * 
 * @param rowid
 * @param rowdata
 * @param sourceUrl
 */	 
function addDataRecord(gridName, rowData, sourceUrl, addFormWindow){
	var dataGridId = "#" + gridName;
	var formWindowId = "#" + addFormWindow;	
	$(dataGridId).jqxGrid('render');
	 
	/* Synchronize with the server - send insert command */
    delete rowData.id; 
    
    /* Remove the uid element that jqxGrid magically puts in */
    delete rowData.uid; 
   
    /* Prepare the json input and end point for POST operation*/
    var jsonString = JSON.stringify(rowData, 1);         
	
	$.ajax({
		contentType: "application/json",
		dataType: 'json', 
        data: jsonString,
        cache: false,
        type: "POST", 
        url: sourceUrl, 
        success: function(jqXHR, textStatus, errorThrown) {
        	//bootbox.alert(jqXHR.responseText + " : " + errorThrown); 
        },
        error: function(jqXHR, textStatus, errorThrown) {
        	bootbox.alert(jqXHR.responseText + " : " + errorThrown); 
        },
      	complete: function(jqXHR, textStatus){	
      		$(formWindowId).jqxWindow('hide');
      		$(dataGridId).jqxGrid('resumeupdate');
            $(dataGridId).jqxGrid('updatebounddata');
    	}
	});
}
	 

 /**
  * Function to handle the delete process in the UI by invoking
  * DELETE service operation.
  * 
  * @param gridName
  * @param selectedRow
  * @param sourceUrl
  * @param errorMessage
  */
 function deleteDataRecord(gridName, selectedRow, sourceUrl, errorMessage){
	 var gridElement = "#"+gridName;
	 var source = sourceUrl + selectedRow.id;

	 /* Delete the record by id */
     $.ajax( {
       dataType: 'json',
       cache: false,
       type: "DELETE", 		    	        
       url: source, 		    	        
       success: function(jqXHR, textStatus, errorThrown) {		    	        	
	        /* Validate for the error/exception status. */
	       	if(jqXHR.status == false){	       		
	       		bootbox.alert(errorMessage);
	       	}
	   },
       error: function(jqXHR, textStatus, errorThrown) {		    	        	
	       	alert("jqXHR.status = "+jqXHR.status);
	       	alert(jqXHR.responseText + " : " + errorThrown);
       },
       complete: function(jqXHR, textStatus){	
     		$(gridElement).jqxGrid('resumeupdate');
     		$(gridElement).jqxGrid('updatebounddata');
   	  }
	});
 }
 
 
 
 /**
  * Function to handle the update process in the UI by invoking
  * PUT(UPDATE) service operation.
  * 
  * @param gridName
  * @param rowData
  * @param sourceUrl
  * @param editFormWindow
  */
 function updateDataRecord(gridName, rowData, sourceUrl, editFormWindow){
	var dataGridId = "#" + gridName;
	var formWindowId = "#" + editFormWindow;
	
	/* Synchronize with the server - send insert command.
	   Remove the uid which created jquery dynamically.*/
	delete rowData.uid;
	var jsonString = JSON.stringify(rowData, 1);

	$.ajax({
		contentType : "application/json",
		dataType : 'json',
		data : jsonString,
		cache : false,
		type : "PUT",
		url : sourceUrl,
		success : function(jqXHR, textStatus, errorThrown) {
			//bootbox.alert(jqXHR.responseText + " : " + errorThrown); 
		},
		error : function(jqXHR, textStatus, errorThrown) {
			bootbox.alert(jqXHR.responseText + " : " + errorThrown);
		},
		complete : function(jqXHR, textStatus) {
			$(formWindowId).jqxWindow('hide');
			$(dataGridId).jqxGrid('resumeupdate');
			$(dataGridId).jqxGrid('updatebounddata');
		}
	});
 }
 
 

 /**
 * Function to handle the update process in the UI by invoking
 * PUT service operation.
 * 
 * @param rowid
 * @param newdata
 * @param source
 */
function updateData(rowid, newdata, source) {

	/** Synchronize with the server - send insert command.
	  Remove the uid which created jquery dynamically.*/
	delete newdata.uid;
	var jsonString = JSON.stringify(newdata, 1);

	$.ajax({
		contentType : "application/json",
		dataType : 'json',
		data : jsonString,
		cache : false,
		type : "PUT",
		url : source,
		success : function(jqXHR, textStatus, errorThrown) {
			//bootbox.alert(jqXHR.responseText + " : " + errorThrown); 
		},
		error : function(jqXHR, textStatus, errorThrown) {
			bootbox.alert(jqXHR.responseText + " : " + errorThrown);
		},
		complete : function(jqXHR, textStatus) {
			$("#foStatusWindowId").jqxWindow('hide');
			$("#foGrid").jqxGrid('resumeupdate');
			$("#foGrid").jqxGrid('updatebounddata');
		}
	});
}
