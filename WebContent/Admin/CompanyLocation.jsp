<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
<!-- start: MAIN CSS -->
<link
	href='http://fonts.googleapis.com/css?family=Raleway:400,300,500,600,700,200,100,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/perfect-scrollbar.css">
<link rel="stylesheet" href="css/animate.min.css">
<!-- end: MAIN CSS -->
<!-- start: CSS REQUIRED FOR SUBVIEW CONTENTS -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/owl.transitions.css">
<link rel="stylesheet" href="css/summernote.css">
<link rel="stylesheet" href="css/fullcalendar.css">
<link rel="stylesheet" href="css/toastr.min.css">
<link rel="stylesheet" href="css/bootstrap-select.min.css">
<link rel="stylesheet" href="css/bootstrap-switch.min.css">
<link rel="stylesheet" href="css/DT_bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-fileupload.min.css">
<link rel="stylesheet"
	href="css/bootstrap-daterangepicker/daterangepicker-bs3.css">
<!-- end: CSS REQUIRED FOR THIS SUBVIEW CONTENTS-->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
<!-- start: CORE CSS -->
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/styles-responsive.css">
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="css/theme-default.css" type="text/css"
	id="skin_color">
<link rel="stylesheet" href="css/print.css" type="text/css"
	media="print" />
<!-- end: CORE CSS -->
<link rel="shortcut icon" href="favicon.ico" />

<title>Insert title here</title>
</head>
<body>
			<%@ include file="Common.jsp" %>
				<!-- start: BREADCRUMB -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<!-- <li>
										<a href="#">
											Dashboard
										</a>
									</li> -->
							<!-- <li class="active">
										Form Validation
									</li> -->
						</ol>
					</div>
				</div>
				<!-- end: BREADCRUMB -->
				<!-- start: PAGE CONTENT -->
				<div class="row">
					<div class="col-md-12">
						<!-- start: FORM VALIDATION 2 PANEL -->
						<div class="panel panel-white">
							<div class="panel-heading">
								<h4 class="panel-title">
									Organzation <span class="text-bold">Information</span>
								</h4>
								<%@ include file="Paneltools.jsp" %>
							</div>
							<div class="panel-body">
								<h2>
									<i class="fa fa-pencil-square"></i> ORGANIZATION LOCATION
								</h2>
								<p>Enter your organization location</p>
								<hr>
								<form action="#" role="form" id="form2">
									<div class="row">
										<div class="col-md-12">
											<div class="errorHandler alert alert-danger no-display">
												<i class="fa fa-times-sign"></i> You have some form errors.
												Please check below.
											</div>
											<div class="successHandler alert alert-success no-display">
												<i class="fa fa-ok"></i> Your form validation is successful!
											</div>
										</div>
										<div class="col-md-7">
											<div class="form-group">
												<label class="control-label"> Organization Name <span
													class="symbol required"></span>
												</label> <input type="text"
													placeholder="Insert your Organization Name"
													class="form-control" id="companylocationorganizationname"
													name="companylocationorganizationname">
											</div>
											<div class="form-group">
												<label class="control-label"> Country <span
													class="symbol required"></span>
												</label> <select class="form-control" id="dropdown" name="companylocationcountry">
													<option value="0">-- Select --</option>
													<option value="AF">Afghanistan</option>
													<option value="AL">Albania</option>
													<option value="DZ">Algeria</option>
													<option value="AS">American Samoa</option>
													<option value="AD">Andorra</option>
													<option value="AO">Angola</option>
													<option value="AI">Anguilla</option>
													<option value="AQ">Antarctica</option>
													<option value="AG">Antigua and Barbuda</option>
													<option value="AR">Argentina</option>
													<option value="AM">Armenia</option>
													<option value="AW">Aruba</option>
													<option value="AU">Australia</option>
													<option value="AT">Austria</option>
													<option value="AZ">Azerbaijan</option>
													<option value="BS">Bahamas</option>
													<option value="BH">Bahrain</option>
													<option value="BD">Bangladesh</option>
													<option value="BB">Barbados</option>
													<option value="BY">Belarus</option>
													<option value="BE">Belgium</option>
													<option value="BZ">Belize</option>
													<option value="BJ">Benin</option>
													<option value="BM">Bermuda</option>
													<option value="BT">Bhutan</option>
													<option value="BO">Bolivia</option>
													<option value="BA">Bosnia and Herzegovina</option>
													<option value="BW">Botswana</option>
													<option value="BV">Bouvet Island</option>
													<option value="BR">Brazil</option>
													<option value="IO">British Indian Ocean Territory</option>
													<option value="BN">Brunei Darussalam</option>
													<option value="BG">Bulgaria</option>
													<option value="BF">Burkina Faso</option>
													<option value="BI">Burundi</option>
													<option value="KH">Cambodia</option>
													<option value="CM">Cameroon</option>
													<option value="CA">Canada</option>
													<option value="CV">Cape Verde</option>
													<option value="KY">Cayman Islands</option>
													<option value="CF">Central African Republic</option>
													<option value="TD">Chad</option>
													<option value="CL">Chile</option>
													<option value="CN">China</option>
													<option value="CX">Christmas Island</option>
													<option value="CC">Cocos (Keeling) Islands</option>
													<option value="CO">Colombia</option>
													<option value="KM">Comoros</option>
													<option value="CG">Congo</option>
													<option value="CD">Congo, the Democratic Republic
														of the</option>
													<option value="CK">Cook Islands</option>
													<option value="CR">Costa Rica</option>
													<option value="CI">Cote D&#039;Ivoire</option>
													<option value="HR">Croatia</option>
													<option value="CU">Cuba</option>
													<option value="CY">Cyprus</option>
													<option value="CZ">Czech Republic</option>
													<option value="DK">Denmark</option>
													<option value="DJ">Djibouti</option>
													<option value="DM">Dominica</option>
													<option value="DO">Dominican Republic</option>
													<option value="EC">Ecuador</option>
													<option value="EG">Egypt</option>
													<option value="SV">El Salvador</option>
													<option value="GQ">Equatorial Guinea</option>
													<option value="ER">Eritrea</option>
													<option value="EE">Estonia</option>
													<option value="ET">Ethiopia</option>
													<option value="FK">Falkland Islands (Malvinas)</option>
													<option value="FO">Faroe Islands</option>
													<option value="FJ">Fiji</option>
													<option value="FI">Finland</option>
													<option value="FR">France</option>
													<option value="GF">French Guiana</option>
													<option value="PF">French Polynesia</option>
													<option value="TF">French Southern Territories</option>
													<option value="GA">Gabon</option>
													<option value="GM">Gambia</option>
													<option value="GE">Georgia</option>
													<option value="DE">Germany</option>
													<option value="GH">Ghana</option>
													<option value="GI">Gibraltar</option>
													<option value="GR">Greece</option>
													<option value="GL">Greenland</option>
													<option value="GD">Grenada</option>
													<option value="GP">Guadeloupe</option>
													<option value="GU">Guam</option>
													<option value="GT">Guatemala</option>
													<option value="GN">Guinea</option>
													<option value="GW">Guinea-Bissau</option>
													<option value="GY">Guyana</option>
													<option value="HT">Haiti</option>
													<option value="HM">Heard Island and Mcdonald
														Islands</option>
													<option value="VA">Holy See (Vatican City State)</option>
													<option value="HN">Honduras</option>
													<option value="HK">Hong Kong</option>
													<option value="HU">Hungary</option>
													<option value="IS">Iceland</option>
													<option value="IN">India</option>
													<option value="ID">Indonesia</option>
													<option value="IR">Iran, Islamic Republic of</option>
													<option value="IQ">Iraq</option>
													<option value="IE">Ireland</option>
													<option value="IL">Israel</option>
													<option value="IT">Italy</option>
													<option value="JM">Jamaica</option>
													<option value="JP">Japan</option>
													<option value="JO">Jordan</option>
													<option value="KZ">Kazakhstan</option>
													<option value="KE">Kenya</option>
													<option value="KI">Kiribati</option>
													<option value="KP">Korea, Democratic People&#039;s
														Republic of</option>
													<option value="KR">Korea, Republic of</option>
													<option value="KW">Kuwait</option>
													<option value="KG">Kyrgyzstan</option>
													<option value="LA">Lao People&#039;s Democratic
														Republic</option>
													<option value="LV">Latvia</option>
													<option value="LB">Lebanon</option>
													<option value="LS">Lesotho</option>
													<option value="LR">Liberia</option>
													<option value="LY">Libyan Arab Jamahiriya</option>
													<option value="LI">Liechtenstein</option>
													<option value="LT">Lithuania</option>
													<option value="LU">Luxembourg</option>
													<option value="MO">Macao</option>
													<option value="MK">Macedonia, the Former Yugoslav
														Republic of</option>
													<option value="MG">Madagascar</option>
													<option value="MW">Malawi</option>
													<option value="MY">Malaysia</option>
													<option value="MV">Maldives</option>
													<option value="ML">Mali</option>
													<option value="MT">Malta</option>
													<option value="MH">Marshall Islands</option>
													<option value="MQ">Martinique</option>
													<option value="MR">Mauritania</option>
													<option value="MU">Mauritius</option>
													<option value="YT">Mayotte</option>
													<option value="MX">Mexico</option>
													<option value="FM">Micronesia, Federated States of</option>
													<option value="MD">Moldova, Republic of</option>
													<option value="MC">Monaco</option>
													<option value="MN">Mongolia</option>
													<option value="MS">Montserrat</option>
													<option value="MA">Morocco</option>
													<option value="MZ">Mozambique</option>
													<option value="MM">Myanmar</option>
													<option value="NA">Namibia</option>
													<option value="NR">Nauru</option>
													<option value="NP">Nepal</option>
													<option value="NL">Netherlands</option>
													<option value="AN">Netherlands Antilles</option>
													<option value="NC">New Caledonia</option>
													<option value="NZ">New Zealand</option>
													<option value="NI">Nicaragua</option>
													<option value="NE">Niger</option>
													<option value="NG">Nigeria</option>
													<option value="NU">Niue</option>
													<option value="NF">Norfolk Island</option>
													<option value="MP">Northern Mariana Islands</option>
													<option value="NO">Norway</option>
													<option value="OM">Oman</option>
													<option value="PK">Pakistan</option>
													<option value="PW">Palau</option>
													<option value="PS">Palestinian Territory, Occupied</option>
													<option value="PA">Panama</option>
													<option value="PG">Papua New Guinea</option>
													<option value="PY">Paraguay</option>
													<option value="PE">Peru</option>
													<option value="PH">Philippines</option>
													<option value="PN">Pitcairn</option>
													<option value="PL">Poland</option>
													<option value="PT">Portugal</option>
													<option value="PR">Puerto Rico</option>
													<option value="QA">Qatar</option>
													<option value="RE">Reunion</option>
													<option value="RO">Romania</option>
													<option value="RU">Russian Federation</option>
													<option value="RW">Rwanda</option>
													<option value="SH">Saint Helena</option>
													<option value="KN">Saint Kitts and Nevis</option>
													<option value="LC">Saint Lucia</option>
													<option value="PM">Saint Pierre and Miquelon</option>
													<option value="VC">Saint Vincent and the
														Grenadines</option>
													<option value="WS">Samoa</option>
													<option value="SM">San Marino</option>
													<option value="ST">Sao Tome and Principe</option>
													<option value="SA">Saudi Arabia</option>
													<option value="SN">Senegal</option>
													<option value="CS">Serbia and Montenegro</option>
													<option value="SC">Seychelles</option>
													<option value="SL">Sierra Leone</option>
													<option value="SG">Singapore</option>
													<option value="SK">Slovakia</option>
													<option value="SI">Slovenia</option>
													<option value="SB">Solomon Islands</option>
													<option value="SO">Somalia</option>
													<option value="ZA">South Africa</option>
													<option value="GS">South Georgia and the South
														Sandwich Islands</option>
													<option value="ES">Spain</option>
													<option value="LK">Sri Lanka</option>
													<option value="SD">Sudan</option>
													<option value="SR">Suriname</option>
													<option value="SJ">Svalbard and Jan Mayen</option>
													<option value="SZ">Swaziland</option>
													<option value="SE">Sweden</option>
													<option value="CH">Switzerland</option>
													<option value="SY">Syrian Arab Republic</option>
													<option value="TW">Taiwan</option>
													<option value="TJ">Tajikistan</option>
													<option value="TZ">Tanzania, United Republic of</option>
													<option value="TH">Thailand</option>
													<option value="TL">Timor-Leste</option>
													<option value="TG">Togo</option>
													<option value="TK">Tokelau</option>
													<option value="TO">Tonga</option>
													<option value="TT">Trinidad and Tobago</option>
													<option value="TN">Tunisia</option>
													<option value="TR">Turkey</option>
													<option value="TM">Turkmenistan</option>
													<option value="TC">Turks and Caicos Islands</option>
													<option value="TV">Tuvalu</option>
													<option value="UG">Uganda</option>
													<option value="UA">Ukraine</option>
													<option value="AE">United Arab Emirates</option>
													<option value="GB">United Kingdom</option>
													<option value="US" selected="selected">United
														States</option>
													<option value="UM">United States Minor Outlying
														Islands</option>
													<option value="UY">Uruguay</option>
													<option value="UZ">Uzbekistan</option>
													<option value="VU">Vanuatu</option>
													<option value="VE">Venezuela</option>
													<option value="VN">Viet Nam</option>
													<option value="VG">Virgin Islands, British</option>
													<option value="VI">Virgin Islands, U.s.</option>
													<option value="WF">Wallis and Futuna</option>
													<option value="EH">Western Sahara</option>
													<option value="YE">Yemen</option>
													<option value="ZM">Zambia</option>
													<option value="ZW">Zimbabwe</option>

												</select>
											</div>
											<div class="form-group">
												<label class="control-label"> Address <em>(Optional)</em>
												</label> <input type="text" class="form-control" name="companylocationaddress"
													id="address1">
											</div>
											<div class="form-group">
												<label class="control-label"> Address Street2<em>(Optional)</em>
												</label> <input type="text" class="form-control" name="companylocationaddress"
													id="address1">
											</div>
											<div class="form-group">
												<!-- <label class="control-label">
															Tax ID<em>(Optional)</em> 
														</label>
														<input type="text" placeholder="Tax-ID" class="form-control" id="taxid" name="taxid"> -->
											</div>
											<div class="form-group">
												<label class="control-label"> FAX Number </span>
												</label> <input type="text" class="form-control" id="fax" name="fax">
											</div>
											<div class="form-group">
												<label class="control-label"> Phone <span
													class="symbol required"></span>
												</label> <input type="text" class="form-control" id="phone"
													name="companylocationphone">
											</div>
											<div class="form-group">
												<!-- <label class="control-label">
															Address Street2<em>(Optional)</em> 
														</label>
														<input type="text" class="form-control" name="address1" id="address1"> -->
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label class="control-label"> Zip Code <span
															class="symbol required"></span>
														</label> <input class="form-control" type="text" name="companylocationzipcode"
															id="zipcode">
													</div>
												</div>
												<div class="col-md-8">
													<div class="form-group">
														<label class="control-label"> City <span
															class="symbol required"></span>
														</label> <input class="form-control tooltips" type="text"
															data-original-title="We'll display it when you write reviews"
															data-rel="tooltip" title="" data-placement="top"
															name="companylocationcity" id="companylocationcity">
													</div>
												</div>
											</div>
										</div>
									
							
							<div class="row" style="margin-left: 0.9px;">
								<div class="col-md-9">
									<div class="form-group">
										<label class="control-label"> Notes </label>
										<div class="summernote"></div>
										<!-- <textarea class="form-control"
											style="border: 1px solid #E6E8E8" id="editor1" name="editor1"
											cols="7" rows="7"></textarea>
 -->
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div>
										<span class="symbol required"></span>Required Fields
										<hr>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-8"></div>
								<div class="col-md-4" align="center">
									<button class="btn btn-yellow btn-block" type="submit">
										Save
										<!-- <i class="fa fa-arrow-circle-right"></i> -->
									</button>
								</div>
							</div>
						</div>
						
				</form>
			</div>
		</div>
		</div>
		</div>
		</div>
	</div>
						<!-- <div class="form-group">
							<div class="form-group">
																<label class="control-label">
																	City <span class="symbol required"></span>
																</label>
															<input class="form-control tooltips" type="text" data-original-title="We'll display it when you write reviews" data-rel="tooltip"  title="" data-placement="top" name="city2" id="city2">
															</div>
														</div>
														<div class="col-md-8">
															<div class="form-group">
																<label class="control-label">
																	Zip Code <span class="symbol required"></span>
																</label>
																<input class="form-control" type="text" name="zipcode2" id="zipcode2">
															</div>
						</div> -->
					




				
				<!-- end: PAGE CONTENT-->
			
			<div class="subviews">
				<div class="subviews-container"></div>
			</div>
	
		<!-- end: PAGE -->



	<!-- end: MAIN CONTAINER -->
	<!-- start: FOOTER -->
	<footer class="inner">
	<%@ include file="Footer.jsp"%>
	</footer>
	<!-- end: FOOTER -->
	<!-- start: SUBVIEW SAMPLE CONTENTS -->
			<%@ include file="Subviewcontents.jsp"%>
	
	<!-- end: SUBVIEW SAMPLE CONTENTS -->
</div>
	<!-- start: MAIN JAVASCRIPTS -->
	<!--[if lt IE 9]>
		<script sssrc="respond.min.js"></script>
		<script src="excanvas.min.js"></script>
		<script type="text/javascript" src="jQuery/jquery-1.11.1.min.js"></script>
		<![endif]-->
	<!--[if gte IE 9]><!-->
	<script src="js/jquery-2.1.1.min.js"></script>
	<!--<![endif]-->
	<script src="js/jquery-ui-1.10.2.custom.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.blockUI.js"></script>
	<script src="js/jquery.icheck.min.js"></script>
	<script src="js/moment.min.js"></script>
	<script src="js/jquery.mousewheel.js"></script>
	<script src="js/perfect-scrollbar.js"></script>
	<script src="js/bootbox.min.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery-scrolltofixed-min.js"></script>
	<script src="js/jquery.appear.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/jquery.velocity.min.js"></script>
	<script src="js/jquery.touchSwipe.min.js"></script>
	<!-- end: MAIN JAVASCRIPTS -->
	<!-- start: JAVASCRIPTS REQUIRED FOR SUBVIEW CONTENTS -->
	<script src="js/owl.carousel.js"></script>
	<script src="js/jquery.mockjax.js"></script>
	<script src="js/toastr.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	<script src="js/bootstrap-modalmanager.js"></script>
	<script src="js/fullcalendar.min.js"></script>
	<script src="js/bootstrap-switch.min.js"></script>
	<script src="js/bootstrap-select.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/bootstrap-fileupload.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/DT_bootstrap.js"></script>
	<script src="js/jquery.truncate.js"></script>
	<script src="js/summernote.min.js"></script>
	<script src="js/daterangepicker.js"></script>
	<script src="js/subview.js"></script>
	<script src="js/subview-examples.js"></script>
	<!-- end: JAVASCRIPTS REQUIRED FOR SUBVIEW CONTENTS -->
	<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script src="js/ckeditor.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/form-validation1.js"></script>
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<!-- start: CORE JAVASCRIPTS  -->
	<script src="js/main.js"></script>
	
		<script src="js/form-elements.js"></script>
	<!-- end: CORE JAVASCRIPTS  -->
	<script>
			jQuery(document).ready(function() {
				Main.init();
				SVExamples.init();
				FormValidator.init();
				FormElements.init();
			});
		</script>


</body>
</html>