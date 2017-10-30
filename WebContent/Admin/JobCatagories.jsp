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
<%
   response.setHeader( "Pragma", "no-cache" );
response.setHeader("Cache-Control","private, no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
   response.setDateHeader( "Expires", 0 );
	%>
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
				<!-- start: PAGE CONTENT -->
				<div class="row">
					<div class="col-md-12">
						<!-- start: FORM VALIDATION 2 PANEL -->
						<div class="panel panel-white">
							<div class="panel-heading">
								<h4 class="panel-title">
									<span class="text-bold">Job Catagories</span>
								</h4>
								<%@ include file="Paneltools.jsp" %>
							</div>
							<div class="panel-body">
								<h2>
									<i class="fa fa-pencil-square"></i>Add Job Catagories
								</h2>

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
												<label class="control-label"> Name <span
													class="symbol required"></span>
												</label> <input type="text" placeholder="Insert the Job Catagory"
													class="form-control" id="jobcatagory" name="jobcatagory">
											</div>


										</div>
									</div>
									<br>
									<hr>

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
			});
		</script>


</body>
</html>