var FormValidator = function () {
	"use strict";
	var validateCheckRadio = function (val) {
        $("input[type='radio'], input[type='checkbox']").on('ifChecked', function(event) {
			$(this).parent().closest(".has-error").removeClass("has-error").addClass("has-success").find(".help-block").hide().end().find('.symbol').addClass('ok');
		});
    }; 
    // function to initiate Validation Sample 1
    var runValidator1 = function () {
        var form1 = $('#form');
        var errorHandler1 = $('.errorHandler', form1);
        var successHandler1 = $('.successHandler', form1);
        $.validator.addMethod("FullDate", function () {
            //if all values are selected
            if ($("#dd").val() != "" && $("#mm").val() != "" && $("#yyyy").val() != "") {
                return true;
            } else {
                return false;
            }
        }, 'Please select a day, month, and year');
        $('#form').validate({
            errorElement: "span", // contain the error msg in a span tag
            errorClass: 'help-block',
            errorPlacement: function (error, element) { // render error placement for each input type
                if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
                    error.insertAfter($(element).closest('.form-group').children('div').children().last());
                } else if (element.attr("name") == "dd" || element.attr("name") == "mm" || element.attr("name") == "yyyy") {
                    error.insertAfter($(element).closest('.form-group').children('div'));
                } else {
                    error.insertAfter(element);
                    // for other inputs, just perform default behavior
                }
            },
            ignore: "",
            rules: {
            	leaveentitlementemp: {
                    minlength: 2,
                    required: true
                },
            	employeename: {
                    minlength: 2,
                    required: true
                },
                firstname: {
                    minlength: 2,
                    required: true
                },
                lastname: {
                    minlength: 2,
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                password: {
                    minlength: 6,
                    required: true
                },
                password_again: {
                    required: true,
                    minlength: 6,
                    equalTo: "#password"
                },
                yyyy: "FullDate",
                gender: {
                    required: true
                },
                zipcode: {
                    required: true,
                    number: true,
                    minlength: 5
                },
                city: {
                    required: true
                },
                assignleavetxtLeaveType: {
                	required: true
                },
                
                datetime: {
                	required: true
                },
                assignleavetxtLeaveType: {
                    required: true
                },
                newsletter: {
                    required: true
                }
            },
            messages: {
            	leaveentitlementemp: "Please specify employee name",
            	employeename: "Please specify employee name",
                firstname: "Please specify your first name",
                lastname: "Please specify your last name",
                email: {
                    required: "We need your email address to contact you",
                    email: "Your email address must be in the format of name@domain.com"
                },
                gender: "Please check a gender!"
            },
            groups: {
                DateofBirth: "dd mm yyyy",
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                successHandler1.hide();
                errorHandler1.show();
            },
            highlight: function (element) {
                $(element).closest('.help-block').removeClass('valid');
                // display OK icon
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error').find('.symbol').removeClass('ok').addClass('required');
                // add the Bootstrap error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error');
                // set error class to the control group
            },
            success: function (label, element) {
                label.addClass('help-block valid');
                // mark the current input as valid and display OK icon
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success').find('.symbol').removeClass('required').addClass('ok');
            },
            submitHandler: function (form) {
                successHandler1.show();
                errorHandler1.hide();
                // submit form
                //$('#form').submit();
            }
        });
    };
    // function to initiate Validation Sample 2
    var runValidator2 = function () {
        var form2 = $('#form2');
        var errorHandler2 = $('.errorHandler', form2);
        var successHandler2 = $('.successHandler', form2);
        $.validator.addMethod("greaterThan", function (value, element, param) {
            var $min = $(param);

            if($min.val() != "" ){
            if (this.settings.onfocusout) {
                $min.off(".validate-greaterThan").on("blur.validate-greaterThan", function () {
                    $(element).valid();
                });
            }
            }

            return parseInt(value) > parseInt($min.val());
        }, "To must be greater than From");
        $.validator.addMethod("getEditorValue", function () {
            $("#editor1").val($('#form2 .summernote').code());
            if ($("#editor1").val() != "" && $("#editor1").val().replace(/(<([^>]+)>)/ig, "") != "") {
                $('#editor1').val('');
                return true;
            } else {
                return false;
            }
        }, 'This field is required.');
        form2.validate({
            errorElement: "span", // contain the error msg in a small tag
            errorClass: 'help-block',
            errorPlacement: function (error, element) { // render error placement for each input type
                if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
                    error.insertAfter($(element).closest('.form-group').children('div').children().last());
                } else if (element.hasClass("ckeditor")) {
                    error.appendTo($(element).closest('.form-group'));
                } else {
                    error.insertAfter(element);
                    // for other inputs, just perform default behavior
                }
            },
            ignore: "",
            rules: {
            
            	// Add user rules
            	adduseressrole: {
                   
                    required: true
                },
                addusersupervisorrole: {
                    
                    required: true
                },
                adduseradminrole: {
                   
                    required: true
                },
            	
                adduseremployeename: {
                	minlength: 2,
                    required: true
                },
                adduserusername: {
                	minlength: 5,
                    required: true
                },
                adduserstatus: {
                	
                    required: true
                },
                adduserpassword: {
                	minlength: 6,
                    required: true
                },
                adduserpassword2: {
                	minlength: 6,
                	equalTo: "#adduserpassword",
                    required: true
                }, 
                password: {
                    minlength: 6,
                    required: true
                },
                password_again: {
                    required: true,
                    minlength: 6,
                    equalTo: "#password"
                },
                //Add Nationality rules
                addnationality: {
                    minlength: 2,
                    required: true
                },
                //Add pay grade name rules
            	addpaygname: {
                    minlength: 2,
                    required: true
                },
                addpaygcurrency: {
                    required: true
                },
                currency: {
                    required: true
                },
                
                addpaygminamt: {
                	number: true
                },
                addpaygmaxamt: {
                	number: true,
                	greaterThan: "#addpaygminamt"
                },
                // Job Title Rules
            	jobtitlename: {
                    minlength: 2,
                    required: true
                },
                jobtitlefile: {
                	required: true,
                	accept: "image/*"
                },
                //Leave Entitlement rules
            	leaveentitlementemp: {
                    required: true
                },
                leaveentitlementLeaveType: {
            		required: true
            	},
                leaveentitlementperiod: {
                	required: true,
                	/*remote: {
						//verbose: false,
						message: "Cannot add days",
	                    url: 'addperiod.jsp',
	                    type: 'POST',
	                    //async: false,// Send Ajax request every 2 seconds
	                    data:
	                      {
	                    	leaveentitlementperiod: function()
	                          {
	                              return $('#leaveentitlementperiod').val();
	                          }
	                      }
	                    
	                }*/
                },
                // Assign leave to employee rules
                assignleaveemployeename: {
                    required: true
                },
                assignleaveLeaveType: {
                    required: true
                },
                assignleaveperiod: {
                	required: true
                },
                //Apply for Leave Rules
                ApplyforLeaveLeaveType: {
                	required: true
                },
                ApplyforLeaveperiod: {
                	required: true
                },
                // Employment Status Rules 
            	employmentstatus: {
                    minlength: 2,
                    required: true
                },
                // Job Category Rules
                jobcatagory: {
                    minlength: 2,
                    required: true
                },
                //work shift rules
            	workshiftname: {
                    minlength: 2,
                    required: true
                },
                workshiftfrom: {
                	required: true
                },
                workshiftto: {
                	required: true,
                	greaterThan: "#workshiftfrom"
                },
                // Salary Components rules
                salarycomponentname: {
                    minlength: 2,
                    required: true
                },
                salarycomponentvaluetype: {
                    required: true
                },
                
                salarycomponenttype: {
                    required: true
                },
                
                salarycomponentaddto: {
                    required: true
                },
                //Company Location rules
                companylocationorganizationname: {
                    minlength: 2,
                    required: true
                },
                companylocationcountry: {
                    required: true
                },
                companylocationzipcode: {
                    required: true,
                    number: true,
                    minlength: 5
                },
                companylocationcity: {
                    required: true
                },
                companylocationphone: {
                    required: true,
                    number: true,
                    minlength: 10
                },
                //Organization Details rules
                orgdetailsorganizationname: {
                    minlength: 2,
                    required: true
                },
                orgdetailscountry: {
                    required: true
                },
                orgdetailszipcode: {
                    required: true,
                    number: true,
                    minlength: 5
                },
                orgdetailscity: {
                    required: true
                },
                orgdetailsphone: {
                    required: true,
                    number: true,
                    minlength: 10
                },
                orgdetailsnumberofemployee: {
                	number: true,
                    minlength: 2,
                    required: true
                },
                
                orgdetailsemail: {
                    required: true,
                    email: true
                },
               //
                occupation: {
                    required: true
                },
               
                services: {
                    required: true,
                    minlength: 2
                },
               
                url: {
                    required: true,
                    url: true
                },
               
               
                
                
                
                editor1: "getEditorValue",
                editor2: {
                    required: true
                }
            },
            messages: {
            	 adduseremployeename: "Please specify Employee name",
            	 adduserusername: "Please specify User name",
            	 adduserpassword: "Please specify Password",
            	 adduserpassword2: "Please confirm password",
            	addnationality: "Please specify Nationality",
            	addpaygname: "Please specify the pay grade",
            	addpaygmaxamt: "Max must be more than min",
            	addpaygcurrency: "Please specify the currency",
            	jobtitlename: "Please specify the job title",
            	leaveentitlementemp: "Please specify employee name",
            	assignleaveemployeename: "Please specify employee name",
            	orgdetailsorganizationname: "Please specify Organization name",
            	companylocationorganizationname: "Please specify Organization name",
                workshiftname: "Please specify shift name",
                jobcatagory: "Please specify a Job Catagory",
                employmentstatus: "Please specify an employment status",
                salarycomponentname: "Please specify component name",
                lastname: "Please specify your last name",
                ApplyforLeaveLeaveType: "Please Select a leave type",
                ApplyforLeaveperiod: "Specify leave period",
                	
                email: {
                    required: "We need your email address to contact you",
                    email: "Your email address must be in the format of name@domain.com"
                },
                services: {
                    minlength: jQuery.format("Please select  at least {0} types of Service")
                }
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                successHandler2.hide();
                errorHandler2.show();
            },
            highlight: function (element) {
                $(element).closest('.help-block').removeClass('valid');
                // display OK icon
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error').find('.symbol').removeClass('ok').addClass('required');
                // add the Bootstrap error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error');
                // set error class to the control group
            },
            success: function (label, element) {
                label.addClass('help-block valid');
                // mark the current input as valid and display OK icon
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success').find('.symbol').removeClass('required').addClass('ok');
            },
            submitHandler: function (form) {
                successHandler2.show();
                errorHandler2.hide();
                // submit form
                $('#form2').submit();
            }
        });
        $('#form2 .summernote').summernote({
            height: 300
        });
        CKEDITOR.disableAutoInline = true;
        $('textarea.ckeditor').ckeditor();
    };
    return {
        //main function to initiate template pages
        init: function () {
        	validateCheckRadio();
            runValidator1();
            runValidator2();
        }
    };
}();