$(document).ready(function() {
    $('#' + fieldPrefix + '_txtLeaveType').after('<a href="#" id="leave_balance_link">'+lang_CheckLeaveBalance+'</a>');

    $('#leave_balance_link').click(function() {
        showLeaveBalance('current');
    });

    $('#insufficient_balance_link').click(function() {
        $('#leaveBalanceConfirm').modal('hide');
        showLeaveBalance('current');
    });

    $('#prevBtn').click(function() {
        showLeaveBalance('prev');
    });

    $('#nextBtn').click(function() {
        showLeaveBalance('next');
    });

});

function showLeaveBalance(showPeriod) {

    var leaveType = $('#' + fieldPrefix + '_txtLeaveType').val();
    var startDate = $('#' + fieldPrefix + '_txtFromDate').val();
    var endDate =  $('#' + fieldPrefix + '_txtToDate').val();

    var durationType = $('#' + fieldPrefix + '_duration_duration').val();
    var durationAMPM = $('#' + fieldPrefix + '_duration_ampm').val();
    var durationFromTime = $('#' + fieldPrefix + '_duration_time_from').val();
    var durationToTime = $('#' + fieldPrefix + '_duration_time_to').val();

    var duration1Type = $('#' + fieldPrefix + '_firstDuration_duration').val();
    var duration1AMPM = $('#' + fieldPrefix + '_firstDuration_ampm').val();
    var duration1FromTime = $('#' + fieldPrefix + '_firstDuration_time_from').val();
    var duration1ToTime = $('#' + fieldPrefix + '_firstDuration_time_to').val();

    var duration2Type = $('#' + fieldPrefix + '_secondDuration_duration').val();
    var duration2AMPM = $('#' + fieldPrefix + '_secondDuration_ampm').val();
    var duration2FromTime = $('#' + fieldPrefix + '_secondDuration_time_from').val();
    var duration2ToTime = $('#' + fieldPrefix + '_secondDuration_time_to').val();

    var partialDayOption = $('#' + fieldPrefix + '_partialDays').val();

    var empIdField = $('#' + fieldPrefix + '_txtEmployee_empId');
    var empIdNeeded;
    var empId;

    if (empIdField.length === 0) {
        empIdNeeded = false;
        empId = null;
    } else {
        empIdNeeded = true;
        empId = empIdField.val();
    }

    var otherParams = '';
    var action = '';
    var requiredLeavePeriodOffset = 0;

    if (showPeriod !== undefined) {
        if (showPeriod == 'next') {
            requiredLeavePeriodOffset = leavePeriodOffset + 1;
            action = 'next';
        } else if (showPeriod == 'prev') {
            requiredLeavePeriodOffset = leavePeriodOffset - 1;
            action = 'prev';
            otherParams = '&period=' + action;
        } else if (showPeriod === 'current') {
            action = 'current';
        } else {
            action = 'get_balance';
            otherParams = '&get_balance=1';
        }

    } else {
        action = 'get_balance';
        otherParams = '&get_balance=1';
    }

    if (requiredLeavePeriodOffset != 0) {
        otherParams = '&period=' + requiredLeavePeriodOffset;
    }


    if (action == 'get_balance' && (leaveType === '' || (empIdNeeded && empId === ""))) {
        return;
    }


        var params = '&leaveType=' + leaveType + '&startDate=' + startDate + '&endDate=' + endDate +
            '&duration=' + durationType + '&duration_ampm=' + durationAMPM + '&durationFromTime=' +  durationFromTime + '&durationToTime=' + durationToTime +
            '&duration1=' + duration1Type + '&duration_ampm1=' + duration1AMPM + '&durationFromTime1=' +  duration1FromTime + '&durationToTime1=' + duration1ToTime +
            '&duration2=' + duration2Type + '&duration_ampm2=' + duration2AMPM + '&durationFromTime2=' +  duration2FromTime + '&durationToTime2=' + duration2ToTime +
            '&partialDays=' + partialDayOption + otherParams;

        if (empIdNeeded) {
            params = params + '&empNumber=' + empId;
        }
        $.ajax({
            type: 'GET',
            url: leaveBalanceUrl,
            data: params,
            dataType: 'json',
            success: function(data) {

                if (action == 'get_balance') {
                    if (data.haveBalance) {
                        leaveBalanceNegative = false;
                    } else {
                        leaveBalanceNegative = true;
                    }

                    $('#leave_days').text(data.totalDays);

                } else if (data.errors && data.errors.length) {
                    var html = '';
                    var rowCount = data.errors.length;

                    for (var i = 0; i < rowCount; i++) {
                        var message = data.errors[i];

                        html += '<li>' + message + '</li>';
                    }

                    $('div#available_leave_balance_error_div ol').html('').append(html);
                    $('div#available_leave_balance_error_div').modal();

                } else {
                    $('div#available_leave_balance_error_div ol').html('<li></li>');

                    var html = '';
                    var rowCount = data.data.length;

                    for (var i = 0; i < rowCount; i++) {
                        var row = data.data[i];
                        var css = i % 2 ? "even" : "odd";

                        html += '<tr class="' + css + '"><td>' + row.balance + '</td><td>' + row.from +
                            '</td><td>' + row.to + '</td><td>' + row.note + '</td></tr>';
                    }

                    $('div#available_leave_balance_div table.table tbody').html('').append(html);
                    $('div#available_leave_balance_div').modal();
                }

                leavePeriodOffset = requiredLeavePeriodOffset;

            }
        });
}
