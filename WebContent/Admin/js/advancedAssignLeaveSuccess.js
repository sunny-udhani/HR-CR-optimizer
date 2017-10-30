$(document).ready(function() {
	
    if(isCountryBasedEnabled && $('#assignleave_txtLeaveType').val() == ''){
        // disabling of leave type select removed, because jquery does
        // not validate disabled input fields.
    }
    
    if (haveLeaveTypes) {
        $("#assignleave_txtEmployee_empName").result(function(event, item) {
            if(isCountryBasedEnabled){
                loadLeaveTypes(item.id);
                $.ajax({
                    url: 'getHolidayAjaxCountryBased',                
                    data :  "empId="+item.id,
                    dataType: 'json',
                    success: function(hList){
                        daymarker.setHolidayList(hList);
                    },
                    error:function(request){
                        daymarker.setHolidayList([]);
                    }
                });

                $.ajax({
                    url: 'getWorkWeekAjaxCountryBased',                
                    data :  "empId="+item.id,
                    dataType: 'json',
                    success: function(hList){
                        daymarker.setdaysOffList(hList);
                    },
                    error:function(request){
                        daymarker.setdaysOffList([]);
                    }
                });
            }
        });
    }
});


function loadLeaveTypes(empNumber) {
    $('#leave_type_loader').remove();
    $('#assignleave_txtLeaveType')
        .empty()
        .append($("<option></option>")
            .attr("value", '')
            .text(lang_select))
        .after('<div class="loading_message" id="leave_type_loader">&nbsp;</div>');
    
    $.ajax({
           url: "getLeaveTypeAjaxCountryBased",
           data: "empNumber="+empNumber,
           dataType: 'json',
           success: function(leaveTypeList){
   
                $('#assignleave_txtLeaveType')
                    .empty()
                    .append($("<option></option>")
                        .attr("value", '')
                        .text(lang_select));
    
                for (i = 0; i < leaveTypeList.length; i++) {             
                    $('#assignleave_txtLeaveType').append($("<option></option>")
                        .attr("value", leaveTypeList[i][0])
                        .text(leaveTypeList[i][1]));
                } 
                $('#leave_type_loader').remove();               
           }
         });

}

