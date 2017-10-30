<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/AddLeaveEntitlement"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave Entitlements</title>
<meta charset="utf-8" />
<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
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
							<li class="active">Leave Entitlement</li> -->
						</ol>
					</div>
				</div>
				<!-- end: BREADCRUMB -->
				<!-- start: PAGE CONTENT -->
				<div class="row">
					<div class="col-md-12">
						<!-- start: FORM VALIDATION 1 PANEL -->
						<div class="panel panel-white">
							<div class="panel-heading">
								<h4 class="panel-title">
								Leave Entitlements
								</h4>
								<%@ include file="Paneltools.jsp" %>
							</div>
							<div class="panel-body">
								<h2>
									<i class="fa fa-search fa-1x"></i>  Leaves Entitled
								</h2>

								<hr>
								<form action="<%=application.getContextPath()%>/ViewLeaveEntitlement" method="post" role="form" id="form2">
									<input type="hidden" name="flag" value="search">
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
												<label class="control-label"> Employee <span
													class="symbol required"></span>
												</label> 
												 <select id="viewleaveentitlementemp" name="viewleaveentitlementemp" class="form-control search-select" >
													<option value="0" selected="selected">--Select--</option>
													<c:forEach var="x" items="${sessionScope.emplist }">
													<option value="${x.id }">${x.full_name }</option>
													</c:forEach>
												</select>
											</div>



											<div class="form-group connected-group">
												<label class="control-label"> Leave Type <span
													class="symbol required"></span>
												</label>
												<div class="row">
													<div class="col-md-12">
														<select name="viewleaveentitlementtype"
															id="viewleaveentitlementtype" class="form-control">

															<option value="0" selected="selected">All</option>
															<c:forEach var="xmod" items="${sessionScope.typelist }">
												
															<option value="${xmod.id }">${xmod.leavetype }</option>
												
															</c:forEach>

														</select>
													</div>
													
												</div>
											</div>
										
										
											<!--  <div class="form-group connected-group">
												<p>Leave Period<span class="symbol required"></span></p>
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="fa fa-calendar"></i>
													</span> <input type="text" id="viewleaveentitlementperiod" name="viewleaveentitlementperiod" class="form-control date-range">
												</div>
											</div> -->
								<!-- <h5>Entitlements (days)</h5>
											<input id="demo4" type="text" value="0" name="demo4">
											 --></div>
										</div>
									
										<hr>
									<div class="row">
										<div class="col-md-12">
											<div>
												<span class="symbol required"></span>Required Fields
												
											</div>
										</div>
									</div>
							
									<div class="row">
										<div class="col-md-8"></div>
										<div class="col-md-4">
											<button class="btn btn-yellow btn-block" type="submit">
												Search <i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</form>
								</div>
						  </div>
						
						<div class="row">
					      <div class="col-md-12"> 
						    <div class="panel panel-white">
						      <div class="panel-heading">
								
								<%@ include file="Paneltools.jsp" %>
							  </div>
								<div class="panel-body">
								<!-- <div class="col-md-2"></div> -->
										<div class="col-md-2">
											<a href="AddLeaveEntitlement.jsp">
											<button class="btn btn-yellow btn-block">
												Add <!-- <i class="fa fa-search"></i> -->
											</button>
											</a>
										</div>
										<form method="post" action="<%=application.getContextPath() %>/ViewLeaveEntitlement">
										<div class="col-md-2">
										   
										   <input type="hidden" name="flag" value="Delete"/>
											<button class="btn btn-yellow btn-block" type="submit">
												Delete <!-- <i class="fa fa-search"></i> -->
											</button>
										</div>
										<br/>
										<br/>
										<hr/> 
										<div class="form-group">
										  <table class="table table-striped table-hover" id="sample-table-2">
											<thead>
												<tr>
													<th class="center">
													<div class="checkbox-table">
														<label>
															<input type="checkbox" class="flat-grey selectall" name="checkbox-delete" id="checkbox-delete" value="0">
														</label>
													</div></th>
													<th>Leave Type</th>
													<th class="hidden-xs">From</th>
													<th class="hidden-xs">To</th>
													<th class="hidden-xs">Days</th>
													
												</tr>
											</thead>
											
											<tbody>
											<%-- <c:if test="${sessionScope.xlist }!=null"> --%>
												<c:forEach items="${sessionScope.xlist }" var="xj">
												<tr>
													<td class="center">
													<div class="checkbox-table">
														<label>
															<input type="checkbox" class="flat-grey foocheck" name="checkbox-delete" id="checkbox-delete" value="${xj.leaveEntitlement_id}">
														</label>
													</div></td>
													
													<td><a href="EditLeaveEntitlement.jsp?id=${xj.leaveEntitlement_id}" title="Click to Edit this Entitlement">${xj.leaveEntitlement_type.leavetype}</a></td>
													<td>${xj.leaveEntitlement_startday }</td>
													<td>${xj.leaveEntitlement_endday }</td>
													<td>${xj.leaveEntitlement_days} </td>
											   </tr>
											</c:forEach>
											<%-- </c:if> --%>
											<%-- <c:if test="${sessionScope.list }==null">
											<tr>
											<td>No records</td>
											</tr>
											</c:if> --%>
											</tbody>
										</table>
										<%-- <table>
										<c:forEach var="xy" items="${sessionScope.xlist }">
										<tr>
										
										<td> ${xy.leaveEntitlement_type.leavetype} </td>
										<td> ${xy.leaveEntitlement_days} </td>
										<td> ${xy.leaveEntitlement_startday} </td>
										<td> ${xy.leaveEntitlement_endday} </td>
									    
									    </tr>
										</c:forEach>
										</table>
										 --%>
										</div>
									</form>
									<%session.removeAttribute("xlist"); %>
								</div>
						
						    </div>
									
										<hr>
										
									<!-- <div class="row">
										 <div class="col-md-2"></div>
										<div class="col-md-4">
											<button class="btn btn-yellow btn-block" type="submit">
												Search <i class="fa fa-search"></i>
											</button>
										</div>
									</div> -->
							
						 <!-- end: FORM VALIDATION 1 PANEL -->
					</div>
				</div>

				<!-- end: PAGE CONTENT-->
			</div>
		</div>
		
	</div>
</div>
			<div class="subviews">
				<div class="subviews-container"></div>
			</div>
		
		<!-- end: PAGE -->

		<!-- end: MAIN CONTAINER -->
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