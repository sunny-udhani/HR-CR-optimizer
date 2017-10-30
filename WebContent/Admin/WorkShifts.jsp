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
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="js/orangehrm.autocomplete.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/jquery.tipTip.minified.js"></script>
<script type="text/javascript" src="js/bootstrap-modal.js"></script>
<script type="text/javascript" src="js/jquery.clickoutside.js"></script>
<script type="text/javascript" src="js/hoverIntent.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript" src="js/orangehrm.validate.js"></script>
<script type="text/javascript" src="js/archive.js"></script>


<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->



<script type="text/javascript" src="js/workShiftSuccess.js"></script>
<script type="text/javascript" src="js/jquery.treetable.js"></script>
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

<title>Form</title>
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
									<span class="text-bold">Work Shifts</span>
								</h4>
								<%@ include file="Paneltools.jsp" %>
							</div>
							<div class="panel-body">
								<h2>
									<i class="fa fa-pencil-square"></i>Add Work Shifts
								</h2>

								<hr>
								<form action="<%=application.getContextPath() %>/AddWorkshift" method="post" role="form" id="form2">
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
												<label class="control-label"> Shift Name <span
													class="symbol required"></span>
												</label> <input type="text" placeholder="Insert the Shift Name"
													class="form-control" id="workshiftname" name="workshiftname">
											</div>
											<div class="form-group">
												<label class="control-label"> Work Hours </label> <br>
												<label class="control-label"> From&nbsp; <span
													class="symbol required"></span>
												</label> <select class="form-control" id="workshiftfrom" name="workshiftfrom">
													<option value="" selected="selected"></option>
													<option value="0000">00:00</option>
													<option value="0015">00:15</option>
													<option value="0030">00:30</option>
													<option value="0045">00:45</option>
													<option value="0100">01:00</option>
													<option value="0115">01:15</option>
													<option value="0130">01:30</option>
													<option value="0145">01:45</option>
													<option value="0200">02:00</option>
													<option value="0215">02:15</option>
													<option value="0230">02:30</option>
													<option value="0245">02:45</option>
													<option value="0300">03:00</option>
													<option value="0315">03:15</option>
													<option value="0330">03:30</option>
													<option value="0345">03:45</option>
													<option value="0400">04:00</option>
													<option value="0415">04:15</option>
													<option value="0430">04:30</option>
													<option value="0445">04:45</option>
													<option value="0500">05:00</option>
													<option value="0515">05:15</option>
													<option value="0530">05:30</option>
													<option value="0545">05:45</option>
													<option value="0600">06:00</option>
													<option value="0615">06:15</option>
													<option value="0630">06:30</option>
													<option value="0645">06:45</option>
													<option value="0700">07:00</option>
													<option value="0715">07:15</option>
													<option value="0730">07:30</option>
													<option value="0745">07:45</option>
													<option value="0800">08:00</option>
													<option value="0815">08:15</option>
													<option value="0830">08:30</option>
													<option value="0845">08:45</option>
													<option value="0900">09:00</option>
													<option value="0915">09:15</option>
													<option value="0930">09:30</option>
													<option value="0945">09:45</option>
													<option value="1000">10:00</option>
													<option value="1015">10:15</option>
													<option value="1030">10:30</option>
													<option value="1045">10:45</option>
													<option value="1100">11:00</option>
													<option value="1115">11:15</option>
													<option value="1130">11:30</option>
													<option value="1145">11:45</option>
													<option value="1200">12:00</option>
													<option value="1215">12:15</option>
													<option value="1230">12:30</option>
													<option value="1245">12:45</option>
													<option value="1300">13:00</option>
													<option value="1315">13:15</option>
													<option value="1330">13:30</option>
													<option value="1345">13:45</option>
													<option value="1400">14:00</option>
													<option value="1415">14:15</option>
													<option value="1430">14:30</option>
													<option value="1445">14:45</option>
													<option value="1500">15:00</option>
													<option value="1515">15:15</option>
													<option value="1530">15:30</option>
													<option value="1545">15:45</option>
													<option value="1600">16:00</option>
													<option value="1615">16:15</option>
													<option value="1630">16:30</option>
													<option value="1645">16:45</option>
													<option value="1700">17:00</option>
													<option value="1715">17:15</option>
													<option value="1730">17:30</option>
													<option value="1745">17:45</option>
													<option value="1800">18:00</option>
													<option value="1815">18:15</option>
													<option value="1830">18:30</option>
													<option value="1845">18:45</option>
													<option value="1900">19:00</option>
													<option value="1915">19:15</option>
													<option value="1930">19:30</option>
													<option value="1945">19:45</option>
													<option value="2000">20:00</option>
													<option value="2015">20:15</option>
													<option value="2030">20:30</option>
													<option value="2045">20:45</option>
													<option value="2100">21:00</option>
													<option value="2115">21:15</option>
													<option value="2130">21:30</option>
													<option value="2145">21:45</option>
													<option value="2200">22:00</option>
													<option value="2215">22:15</option>
													<option value="2230">22:30</option>
													<option value="2245">22:45</option>
													<option value="2300">23:00</option>
													<option value="2315">23:15</option>
													<option value="2330">23:30</option>
													<option value="2345">23:45</option>
												</select> 												
												</div>
												
												<div class="form-group">
												<label class="control-label"> To&nbsp; <span
													class="symbol required"></span>
												</label> <select class="form-control" id="workshiftto" name="workshiftto">
													<option value="" selected="selected"></option>
													<option value="0000">00:00</option>
													<option value="0015">00:15</option>
													<option value="0030">00:30</option>
													<option value="0045">00:45</option>
													<option value="0100">01:00</option>
													<option value="0115">01:15</option>
													<option value="0130">01:30</option>
													<option value="0145">01:45</option>
													<option value="0200">02:00</option>
													<option value="0215">02:15</option>
													<option value="0230">02:30</option>
													<option value="0245">02:45</option>
													<option value="0300">03:00</option>
													<option value="0315">03:15</option>
													<option value="0330">03:30</option>
													<option value="0345">03:45</option>
													<option value="0400">04:00</option>
													<option value="0415">04:15</option>
													<option value="0430">04:30</option>
													<option value="0445">04:45</option>
													<option value="0500">05:00</option>
													<option value="0515">05:15</option>
													<option value="0530">05:30</option>
													<option value="0545">05:45</option>
													<option value="0600">06:00</option>
													<option value="0615">06:15</option>
													<option value="0630">06:30</option>
													<option value="0645">06:45</option>
													<option value="0700">07:00</option>
													<option value="0715">07:15</option>
													<option value="0730">07:30</option>
													<option value="0745">07:45</option>
													<option value="0800">08:00</option>
													<option value="0815">08:15</option>
													<option value="0830">08:30</option>
													<option value="0845">08:45</option>
													<option value="0900">09:00</option>
													<option value="0915">09:15</option>
													<option value="0930">09:30</option>
													<option value="0945">09:45</option>
													<option value="1000">10:00</option>
													<option value="1015">10:15</option>
													<option value="1030">10:30</option>
													<option value="1045">10:45</option>
													<option value="1100">11:00</option>
													<option value="1115">11:15</option>
													<option value="1130">11:30</option>
													<option value="1145">11:45</option>
													<option value="1200">12:00</option>
													<option value="1215">12:15</option>
													<option value="1230">12:30</option>
													<option value="1245">12:45</option>
													<option value="1300">13:00</option>
													<option value="1315">13:15</option>
													<option value="1330">13:30</option>
													<option value="1345">13:45</option>
													<option value="1400">14:00</option>
													<option value="1415">14:15</option>
													<option value="1430">14:30</option>
													<option value="1445">14:45</option>
													<option value="1500">15:00</option>
													<option value="1515">15:15</option>
													<option value="1530">15:30</option>
													<option value="1545">15:45</option>
													<option value="1600">16:00</option>
													<option value="1615">16:15</option>
													<option value="1630">16:30</option>
													<option value="1645">16:45</option>
													<option value="1700">17:00</option>
													<option value="1715">17:15</option>
													<option value="1730">17:30</option>
													<option value="1745">17:45</option>
													<option value="1800">18:00</option>
													<option value="1815">18:15</option>
													<option value="1830">18:30</option>
													<option value="1845">18:45</option>
													<option value="1900">19:00</option>
													<option value="1915">19:15</option>
													<option value="1930">19:30</option>
													<option value="1945">19:45</option>
													<option value="2000">20:00</option>
													<option value="2015">20:15</option>
													<option value="2030">20:30</option>
													<option value="2045">20:45</option>
													<option value="2100">21:00</option>
													<option value="2115">21:15</option>
													<option value="2130">21:30</option>
													<option value="2145">21:45</option>
													<option value="2200">22:00</option>
													<option value="2215">22:15</option>
													<option value="2230">22:30</option>
													<option value="2245">22:45</option>
													<option value="2300">23:00</option>
													<option value="2315">23:15</option>
													<option value="2330">23:30</option>
													<option value="2345">23:45</option>
												</select>

											</div>
											<div class="form-group">
												<p id="selectManyTable">
												<table class="col-md-12">
													<tbody>
														<tr>
															<td width="30%" style="font-weight: bold; height: 20px">
																Available Employees</td>
															<td width="15%"></td>
															<td width="30%" style="font-weight: bold;">Assigned
																Employees</td>
														</tr>
														<tr>
															<td><select name="workShift[availableEmp][]"
																class="selectMany" size="10" style="width: 100%"
																multiple="multiple" id="workShift_availableEmp">
																	<option value="6">Peter Mac Anderson</option>
																	<option value="4">Nancy-Ming Boucher</option>
																	<option value="8">Hannah Flores</option>
																	<option value="2">Russel Hamilton</option>
																	<option value="1">Kevin Mathews</option>
																	<option value="5">Anthony Nolan</option>
																	<option value="9">Ryan Parker</option>
																	<option value="12">Nina Patel</option>
																	<option value="20">Melan Peiris</option>
																	<option value="10">Nicky Silverstone</option>
																	<option value="7">John Smith</option>
																	<option value="11">Jennifer Smith</option>
																	<option value="18">lisa smith</option>
																	<option value="17">Mike Taylor</option>
																	<option value="13">Jacqueline White</option>
																	<option value="19">Luke Wright</option>
															</select></td>
															<td align="center" style="vertical-align: middle"><a
																href="#" class="" id="btnAssignEmployee">Add >></a><br />
															<br /> <a href="#" class="delete" id="btnRemoveEmployee">Remove
																	<<</a></td>
															<td><select name="workShift[assignedEmp][]"
																class="selectMany" size="10" style="width: 100%"
																multiple="multiple" id="workShift_assignedEmp">

															</select></td>
														</tr>
													</tbody>
												</table>
												
											</div>
										</div>
									</div>
									<br>
									<hr>

									<div id="tableWrapper" class="form-group">
										<!-- <table class="table table-hover" id="sample-table-1">
											<thead>
												<tr>
													<th class="center">#</th>
													<th>Shifts</th>
													<th class="hidden-xs">From</th>
													<th>To</th>
													<th class="hidden-xs">Hours per Day</th>
													<th></th>
												</tr>
											</thead>
											</table> -->
										<table class="table table-hover" id="resultTable">

											<thead>
												<tr>
													<th></th>
													<th rowspan="1" style="width:"><span
														class="headerCell">Shift Name</span></th>
													<th rowspan="1" style="width:"><span
														class="headerCell">From</span></th>
													<th rowspan="1" style="width:"><span
														class="headerCell">To</span></th>
													<th rowspan="1" style="width:"><span
														class="headerCell">Hours Per Day</span></th>
												</tr>
											</thead>

											<tbody>

												<tr data-tt-id="" data-tt-parent-id="" class="odd">
													<td><input type="checkbox"
														id="ohrmList_chkSelectRecord_1" name="chkSelectRow[]"
														value="1" /></td>
													<td class="left"><a href="javascript:">Full Day
															Work</a></td>
													<td class="left">09:00</td>
													<td class="left">17:00</td>
													<td class="left">8.00</td>
												</tr>

												<tr data-tt-id="1" data-tt-parent-id="" class="even">
													<td><input type="checkbox"
														id="ohrmList_chkSelectRecord_2" name="chkSelectRow[]"
														value="2" /></td>
													<td class="left"><a href="javascript:">Half Day
															Work</a></td>
													<td class="left">09:00</td>
													<td class="left">13:00</td>
													<td class="left">4.00</td>
												</tr>
											</tbody>
										</table>

									</div>
									<!-- tableWrapper -->

									<!-- <div class="form-group">
														<label class="control-label">
															Address <em>(Optional)</em>
														</label>
														<input type="text" class="form-control" name="address1" id="address1">
													</div>
													<div class="form-group">
														<label class="control-label">
															Address Street2<em>(Optional)</em> 
														</label>
														<input type="text" class="form-control" name="address1" id="address1">
													</div>
																		<div class="form-group">
														<label class="control-label">
															Tax ID<em>(Optional)</em> 
														</label>
														<input type="text" placeholder="Tax-ID" class="form-control" id="taxid" name="taxid">
													</div>
													<div class="form-group">
														<label class="control-label">
															FAX Number </span>
														</label>
														<input type="text" class="form-control" id="fax" name="fax">
													</div>
													<div class="form-group">
														<label class="control-label">
															Phone <span class="symbol required"></span>
														</label>
														<input type="text" class="form-control" id="phone" name="phone">
													</div>
													<div class="form-group">
														<label class="control-label">
															Address Street2<em>(Optional)</em> 
														</label>
														<input type="text" class="form-control" name="address1" id="address1">
													</div>
															<div class="row">
														<div class="col-md-4">
															<div class="form-group">
																<label class="control-label">
																	Zip Code <span class="symbol required"></span>
																</label>
																<input class="form-control" type="text" name="zipcode2" id="zipcode2">
															</div>
														</div> -->
									<!-- 	<div class="col-md-8">
															<div class="form-group">
																<label class="control-label">
																	City <span class="symbol required"></span>
																</label>
																<input class="form-control tooltips" type="text" data-original-title="We'll display it when you write reviews" data-rel="tooltip"  title="" data-placement="top" name="city2" id="city2">
															</div>
														</div>
													</div>
												</div>
											</div>												
													</div>		
											<div class="row" style="margin-left: 0.9px;">
												<div class="col-md-9">
													<div class="form-group">
														<label class="control-label">
															Notes 
														</label>
														<div class="summernote"></div>
														<textarea class="form-control" style="border:1px solid #E6E8E8 " id="editor1" name="editor1" cols="7" rows="7"></textarea>
														
													</div>
												</div>
											</div> -->

									<hr />
									<div class="row">
										<div class="col-md-12">
											<div>
												<span class="symbol required"></span>Required Fields <br />
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
								</form>
							</div>
							<div class="form-group">
								<!-- <div class="form-group">
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
															</div> -->
							</div>
						</div>




					</div>
					<!-- end: PAGE CONTENT-->
				</div>
				<div class="subviews">
					<div class="subviews-container"></div>
				</div>
			</div>
			<!-- end: PAGE -->
		</div>
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

	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<!-- start: CORE JAVASCRIPTS  -->
	<script src="js/main.js"></script>
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