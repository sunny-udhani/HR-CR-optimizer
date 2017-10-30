<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<%
    response.setHeader( "Pragma", "no-cache" );
	response.setHeader("Cache-Control","private, no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
    response.setDateHeader( "Expires", 0 );
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/Addpaygrade"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Pay Grade</title>
<meta charset="utf-8"/>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="-1">
<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
<!-- <link
	href='http://fonts.googleapis.com/css?family=Raleway:400,300,500,600,700,200,100,800'
	rel='stylesheet' type='text/css'> -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/skins/all.css">
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
<link rel="stylesheet" href="css/daterangepicker-bs3.css">
<!-- end: CSS REQUIRED FOR THIS SUBVIEW CONTENTS-->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<link rel="stylesheet" href="css/bootstrap-editable.css">
<link rel="stylesheet" href="css/jquery.bootstrap-touchspin.min.css">
<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/bootstrap-timepicker.min.css">
<link rel="stylesheet" href="css/bootstrap-colorpicker.css">
<link rel="stylesheet" href="css/bootstrap-colorpalette.css">
<link rel="stylesheet" href="css/jquery.tagsinput.css">
<link rel="stylesheet" href="css/typeahead.js-bootstrap.css">
		<link rel="stylesheet" href="css/address.css">
		<link rel="stylesheet" href="css/bootstrap-wysihtml5-0.0.2.css">
		<ink rel="stylesheet" href="css/wysiwyg-color.css">
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
<!-- start: MAIN CSS -->
<!-- <link
	href='http://fonts.googleapis.com/css?family=Raleway:400,300,500,600,700,200,100,800'
	rel='stylesheet' type='text/css'> -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/skins/all.css">
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
<link rel="stylesheet" href="css/daterangepicker-bs3.css">
<!-- end: CSS REQUIRED FOR THIS SUBVIEW CONTENTS-->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<link rel="stylesheet" href="css/jquery.bootstrap-touchspin.min.css">
<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/bootstrap-timepicker.min.css">
<link rel="stylesheet" href="css/bootstrap-colorpicker.css">
<link rel="stylesheet" href="css/bootstrap-colorpalette.css">
<link rel="stylesheet" href="css/jquery.tagsinput.css">
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

</head>
<body>

		<%@ include file="Common.jsp" %>
				<!-- start: BREADCRUMB -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<!-- <li><a href="#"> Dashboard </a></li>
							<li class="active">Form Validation</li> -->
						</ol>
					</div>
				</div>
				<!-- end: BREADCRUMB -->
				<div class="row">
					<div class="col-md-12">
						<!-- start: FORM VALIDATION 1 PANEL -->
						<div class="panel panel-white">
							<div class="panel-heading">
								 <h4 class="panel-title">
									 <span class="text-bold">Pay Grade</span>
								</h4>
								<%@ include file="Paneltools.jsp" %>
							</div>
							<div class="panel-body">
								<h2>
									<i class="fa fa-pencil-square"></i>Edit Pay Grade
								</h2>

								<hr>
								<form action="<%=application.getContextPath() %>/Addpaygrade" method="post" role="form" id="form2">
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
										<div class="col-md-8">
											<div class="form-group">
												<label class="control-label">Pay Grade Name <span
													class="symbol required"></span>
												</label> <input type="text" placeholder="Insert the Pay Grade Name"
													class="form-control" id="paygname" name="addpaygname">
												<hr>
											</div>

											<h2>
												<i class="fa fa-pencil-square"></i>Add Currency
											</h2>

											<div class="form-group">
												<label class="control-label"> Currency Name <span
													class="symbol required"></span>
												</label>  <select id="currency" name="addpaygcurrency"class="form-control search-select" >
												<c:forEach var="x" items="${sessionScope.list }">
												<option>${x.currencyname }</option>
												
												
												
												</c:forEach>
													<!-- 
														"id":"AFN","name":"AFN - Afghanistan Afghani"},{"id":"ALL","name":"ALL - Albanian Lek"},{"id":"DZD","name":"DZD - Algerian Dinar"},{"id":"AOR","name":"AOR - Angolan New Kwanza"},{"id":"ARP","name":"ARP - Argentina Pesos"},{"id":"ARS","name":"ARS - Argentine Peso"},{"id":"AWG","name":"AWG - Aruban Florin"},{"id":"AUD","name":"AUD - Australian Dollar"},{"id":"BSD","name":"BSD - Bahamian Dollar"},{"id":"BHD","name":"BHD - Bahraini Dinar"},{"id":"BDT","name":"BDT - Bangladeshi Taka"},{"id":"BBD","name":"BBD - Barbados Dollar"},{"id":"BZD","name":"BZD - Belize Dollar"},{"id":"BMD","name":"BMD - Bermudian Dollar"},{"id":"BTN","name":"BTN - Bhutan Ngultrum"},{"id":"BOB","name":"BOB - Bolivian Boliviano"},{"id":"BWP","name":"BWP - Botswana Pula"},{"id":"BRL","name":"BRL - Brazilian Real"},{"id":"BND","name":"BND - Brunei Dollar"},{"id":"BGL","name":"BGL - Bulgarian Lev"},{"id":"BIF","name":"BIF - Burundi Franc"},{"id":"CAD","name":"CAD - Canadian Dollar"},{"id":"CVE","name":"CVE - Cape Verde Escudo"},{"id":"KYD","name":"KYD - Cayman Islands Dollar"},{"id":"XOF","name":"XOF - CFA Franc BCEAO"},{"id":"XAF","name":"XAF - CFA Franc BEAC"},{"id":"XPF","name":"XPF - CFP Franc"},{"id":"CLP","name":"CLP - Chilean Peso"},{"id":"CNY","name":"CNY - Chinese Yuan Renminbi"},{"id":"COP","name":"COP - Colombian Peso"},{"id":"KMF","name":"KMF - Comoros Franc"},{"id":"CRC","name":"CRC - Costa Rican Colon"},{"id":"HRK","name":"HRK - Croatian Kuna"},{"id":"CUP","name":"CUP - Cuban Peso"},{"id":"CYP","name":"CYP - Cyprus Pound"},{"id":"CZK","name":"CZK - Czech Koruna"},{"id":"DKK","name":"DKK - Danish Krona"},{"id":"DJF","name":"DJF - Djibouti Franc"},{"id":"DOP","name":"DOP - Dominican Peso"},{"id":"XCD","name":"XCD - Eastern Caribbean Dollars"},{"id":"ECS","name":"ECS - Ecuador Sucre"},{"id":"EGP","name":"EGP - Egyptian Pound"},{"id":"SVC","name":"SVC - El Salvador Colon"},{"id":"EEK","name":"EEK - Estonian Krona"},{"id":"ETB","name":"ETB - Ethiopian Birr"},{"id":"EUR","name":"EUR - Euro"},{"id":"FKP","name":"FKP - Falkland Islands Pound"},{"id":"FJD","name":"FJD - Fiji Dollar"},{"id":"GMD","name":"GMD - Gambian Dalasi"},{"id":"GHC","name":"GHC - Ghanaian Cedi"},{"id":"GIP","name":"GIP - Gibraltar Pound"},{"id":"XAU","name":"XAU - Gold (oz.)"},{"id":"GTQ","name":"GTQ - Guatemalan Quetzal"},{"id":"GNF","name":"GNF - Guinea Franc"},{"id":"GYD","name":"GYD - Guyanan Dollar"},{"id":"HTG","name":"HTG - Haitian Gourde"},{"id":"HNL","name":"HNL - Honduran Lempira"},{"id":"HKD","name":"HKD - Hong Kong Dollar"},{"id":"HUF","name":"HUF - Hungarian Forint"},{"id":"ISK","name":"ISK - Iceland Krona"},{"id":"XDR","name":"XDR - IMF Special Drawing Right"},{"id":"INR","name":"INR - Indian Rupee"},{"id":"IDR","name":"IDR - Indonesian Rupiah"},{"id":"IRR","name":"IRR - Iranian Rial"},{"id":"IQD","name":"IQD - Iraqi Dinar"},{"id":"ILS","name":"ILS - Israeli New Shekel"},{"id":"JMD","name":"JMD - Jamaican Dollar"},{"id":"JPY","name":"JPY - Japanese Yen"},{"id":"JOD","name":"JOD - Jordanian Dinar"},{"id":"KHR","name":"KHR - Kampuchean Riel"},{"id":"KZT","name":"KZT - Kazakhstan Tenge"},{"id":"KES","name":"KES - Kenyan Shilling"},{"id":"KRW","name":"KRW - Korean Won"},{"id":"KWD","name":"KWD - Kuwaiti Dinar"},{"id":"LAK","name":"LAK - Lao Kip"},{"id":"LVL","name":"LVL - Latvian Lats"},{"id":"LBP","name":"LBP - Lebanese Pound"},{"id":"LSL","name":"LSL - Lesotho Loti"},{"id":"LRD","name":"LRD - Liberian Dollar"},{"id":"LYD","name":"LYD - Libyan Dinar"},{"id":"LTL","name":"LTL - Lithuanian Litas"},{"id":"MOP","name":"MOP - Macau Pataca"},{"id":"MGF","name":"MGF - Malagasy Franc"},{"id":"MWK","name":"MWK - Malawi Kwacha"},{"id":"MYR","name":"MYR - Malaysian Ringgit"},{"id":"MVR","name":"MVR - Maldive Rufiyaa"},{"id":"MTL","name":"MTL - Maltese Lira"},{"id":"MRO","name":"MRO - Mauritanian Ouguiya"},{"id":"MUR","name":"MUR - Mauritius Rupee"},{"id":"MXN","name":"MXN - Mexican New Peso"},{"id":"MXP","name":"MXP - Mexican Peso"},{"id":"MNT","name":"MNT - Mongolian Tugrik"},{"id":"MAD","name":"MAD - Moroccan Dirham"},{"id":"MZM","name":"MZM - Mozambique Metical"},{"id":"MMK","name":"MMK - Myanmar Kyat"},{"id":"NAD","name":"NAD - Namibia Dollar"},{"id":"NPR","name":"NPR - Nepalese Rupee"},{"id":"ZRN","name":"ZRN - New Zaire"},{"id":"NZD","name":"NZD - New Zealand Dollar"},{"id":"NIO","name":"NIO - Nicaraguan Cordoba Oro"},{"id":"NGN","name":"NGN - Nigerian Naira"},{"id":"ANG","name":"ANG - NL Antillian Guilder"},{"id":"KPW","name":"KPW - North Korean Won"},{"id":"NOK","name":"NOK - Norwegian Krona"},{"id":"OMR","name":"OMR - Omani Rial"},{"id":"PKR","name":"PKR - Pakistan Rupee"},{"id":"XPD","name":"XPD - Palladium (oz.)"},{"id":"PAB","name":"PAB - Panamanian Balboa"},{"id":"PGK","name":"PGK - Papua New Guinea Kina"},{"id":"PYG","name":"PYG - Paraguay Guarani"},{"id":"PEN","name":"PEN - Peruvian Nuevo Sol"},{"id":"PHP","name":"PHP - Philippine Peso"},{"id":"XPT","name":"XPT - Platinum (oz.)"},{"id":"PLN","name":"PLN - Polish Zloty"},{"id":"GBP","name":"GBP - Pound Sterling"},{"id":"QAR","name":"QAR - Qatari Rial"},{"id":"ROL","name":"ROL - Romanian Leu"},{"id":"RUR","name":"RUR - Russia Rubles"},{"id":"RUB","name":"RUB - Russian Rouble"},{"id":"WST","name":"WST - Samoan Tala"},{"id":"STD","name":"STD - Sao Tome\/Principe Dobra"},{"id":"SAR","name":"SAR - Saudi Arabia Riyal"},{"id":"SCR","name":"SCR - Seychelles Rupee"},{"id":"SLL","name":"SLL - Sierra Leone Leone"},{"id":"XAG","name":"XAG - Silver (oz.)"},{"id":"SGD","name":"SGD - Singapore Dollar"},{"id":"SKK","name":"SKK - Slovak Koruna"},{"id":"SBD","name":"SBD - Solomon Islands Dollar"},{"id":"SOS","name":"SOS - Somali Shilling"},{"id":"ZAR","name":"ZAR - South African Rand"},{"id":"LKR","name":"LKR - Sri Lanka Rupee"},{"id":"SHP","name":"SHP - St. Helena Pound"},{"id":"SDD","name":"SDD - Sudanese Dinar"},{"id":"SDP","name":"SDP - Sudanese Pound"},{"id":"SRD","name":"SRD - Surinamese Dollar"},{"id":"SZL","name":"SZL - Swaziland Lilangeni"},{"id":"SEK","name":"SEK - Swedish Krona"},{"id":"CHF","name":"CHF - Swiss Franc"},{"id":"SYP","name":"SYP - Syrian Pound"},{"id":"TWD","name":"TWD - Taiwan Dollar"},{"id":"TZS","name":"TZS - Tanzanian Shilling"},{"id":"THB","name":"THB - Thai Baht"},{"id":"TOP","name":"TOP - Tongan Pa'anga"},{"id":"TTD","name":"TTD - Trinidad\/Tobago Dollar"},{"id":"TND","name":"TND - Tunisian Dinar"},{"id":"TRL","name":"TRL - Turkish Lira"},{"id":"UGX","name":"UGX - Uganda Shilling"},{"id":"UAH","name":"UAH - Ukraine Hryvnia"},{"id":"USD","name":"USD - United States Dollar"},{"id":"UYP","name":"UYP - Uruguayan Peso"},{"id":"AED","name":"AED - Utd. Arab Emir. Dirham"},{"id":"VUV","name":"VUV - Vanuatu Vatu"},{"id":"VEB","name":"VEB - Venezuelan Bolivar"},{"id":"VND","name":"VND - Vietnamese Dong"},{"id":"YER","name":"YER - Yemeni Riyal"},{"id":"YUN","name":"YUN - Yugoslav Dinar"},{"id":"YUM","name":"YUM - Yugoslavian Dinar"},{"id":"ZMK","name":"ZMK - Zambian Kwacha"},{"id":"ZWD","name":"ZWD - Zimbabwe Dollar"}] ;
   												 -->
   												<!-- <table id="user" class="table table-bordered table-striped">
   												 <tr>
   												 <td>Currency</td>
   												
   												 
												<td>	<a style="color: gray; display: inline;" class="editable editable-click" href="#" id="sex" data-type="select" data-pk="1" data-original-title="Select Currency">not selected</a>
												<div class="editableform-loading" style="display: none;"></div>

												 </td>
												 </tr>
												</table> -->
												</select> 
												</div>
												<div class="form-group">
												<label class="control-label"> Minimum </label> <input
													class="form-control" type="text" name="addpaygminamt" id="minamt">
												<label class="control-label"> Maximum </label> <input
													class="form-control" type="text" name="addpaygmaxamt" id="maxamt">
											</div>



										</div>
								

									<br>

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
										<div class="col-md-4">
											<button class="btn btn-yellow btn-block" type="submit">
												Add <i class="fa fa-arrow-circle-right"></i>
											</button>
										</div>
									</div>
								</div>
								</form>
							</div>
						</div>
						<!-- end: FORM VALIDATION 1 PANEL -->
					</div>
					</div>
					</div>
					</div>
			
					
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
		<script sssrc="js/respond.min.js"></script>
		<script src="jss/excanvas.min.js"></script>
		<script type="text/javascript" src="plugins/jQuery/jquery-1.11.1.min.js"></script>
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
	<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script src="js/jquery.inputlimiter.1.3.1.min.js"></script>
	<script src="js/jquery.autosize.min.js"></script>
	<script src="js/select2.min.js"></script>
	<script src="js/jquery.maskedinput.js"></script>
	<script src="js/jquery.inputlimiter.1.3.1.min.js"></script>
	<script src="js/jquery.maskMoney.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-timepicker.min.js"></script>
	<script src="js/bootstrap-colorpicker.js"></script>
	<script src="js/commits.js"></script>
	<script src="js/bootstrap-colorpalette.js"></script>
	<script src="js/jquery.bootstrap-touchspin.min.js"></script>
	<script src="js/jquery.tagsinput.js"></script>
	<script src="js/bootstrap-fileupload.min.js"></script>
	<script src="js/ckeditor.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/form-elements.js"></script>
	<script src="js/bootstrap-editable.min.js"></script>
		<script src="js/typeaheadjs.js"></script>
		<script src="js/typeahead.js"></script>
		<script src="js/address.js"></script>
		<script src="js/wysihtml5-0.3.0.min.js"></script>
		<script src="js/bootstrap-wysihtml5.js"></script>
		<script src="js/wysihtml5.js"></script>
		<script src="js/demo-mock.js"></script>
		<script src="js/demo.js"></script>
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<!-- start: CORE JAVASCRIPTS  -->
	<script src="js/main.js"></script>
	<script src="js/ckeditor.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/form-validation1.js"></script>
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