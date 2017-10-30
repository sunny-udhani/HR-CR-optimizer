<!DOCTYPE html>
<!-- Template Name: Rapido - Responsive Admin Template build with Twitter Bootstrap 3.x Version: 1.2 Author: ClipTheme -->
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->

<html lang="en" class="no-js">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<head>
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="-1">
	<%
 	response.setHeader( "Pragma", "no-cache" );
	response.setDateHeader( "Expires", 0 );
 	response.setHeader("Cache-Control","private, no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
	%>
		<title>Rapido - Responsive Admin Template</title>
		<!-- start: META -->
		<meta charset="utf-8" />
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="" name="description" />
		<meta content="" name="author" />
		<!-- end: META -->
		<!-- start: MAIN CSS -->
		<!-- <link rel="stylesheet" href="css/owl.carousel.css">
		<link rel="stylesheet" href="css/owl.theme.css">
		<link rel="stylesheet" href="css/owl.transitions.css"> -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/font-awesome.min.css">
		<link rel="stylesheet" href="css/animate.min.css">
		<link rel="stylesheet" href="css/skins/all.css">
		<link rel="stylesheet" href="css/styles.css">
		<link rel="stylesheet" href="css/styles-responsive.css">
		
		<!-- <link rel="stylesheet" href="css/theme-default.css" type="text/css">
		<link rel="stylesheet" href="css/jquery.bootstrap-touchspin.min.css">
		<link rel="stylesheet" href="css/toastr.min.css">
		<link rel="stylesheet" href="css/bootstrap-select.min.css">
		<link rel="stylesheet" href="css/bootstrap-switch.min.css">
		<link rel="stylesheet" href="css/DT_bootstrap.css">
		
<link rel="stylesheet" href="css/perfect-scrollbar.css"> -->
		<!--[if IE 7]>
		
		<link rel="stylesheet" href="font-awesome/css/font-awesome-ie7.min.css">
		<![endif]-->
		<!-- end: MAIN CSS -->
		<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->

		
	</head>
	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body class="login">
		<div class="row">
			<div class="main-login col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
				<div class="logo">
					<!--  <img src="images/logo.png">  -->
				</div>
				<!-- start: LOGIN BOX -->
				<div class="box-login">
					<h3>Sign in to your account</h3>
					<p>
					 <%
					session = request.getSession(false);
					String s = (String)session.getAttribute("Error");
					String uri;
					//out.println(session.getAttribute("requri"));
					uri = (String)session.getAttribute("requri");
					//out.print(uri);
					application.setAttribute("requri", uri);
					if(s!=null)
					{
						out.println("<i style='color:red'>Wrong username/passowrd</i><br/>");
						session.invalidate();
					}
					else
					{
						
						session.removeAttribute("Error");
						session.invalidate();
						
						/* session = request.getSession(true);
						session.setAttribute("requri", uri); */
					}
					
					%> 
						Please enter your name and password to log in.
					</p>
					<form class="form-login" action="<%=application.getContextPath()%>/Login" method="post">
						<div class="errorHandler alert alert-danger no-display">
							<i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
						</div>
						<fieldset>
							<div class="form-group">
								<span class="input-icon">
									<input type="text" class="form-control" name="username" placeholder="Username">
									<i class="fa fa-user"></i> </span>
							</div>
							<div class="form-group form-actions">
								<span class="input-icon">
									<input type="password" class="form-control password" name="password" placeholder="Password">
									<i class="fa fa-lock"></i>
									<a class="forgot" href="ForgotPassword.jsp">
										I forgot my password
									</a> </span>
							</div>
							<div class="form-actions">
								<label for="remember" class="checkbox-inline">
									<input type="checkbox" id="remember" name="remember" class="square-grey">
									Keep me signed in
								</label>
								<button type="submit" class="btn btn-green pull-right">
									Login <i class="fa fa-arrow-circle-right"></i>
								</button>
							</div>
							<div class="new-account">
								Don't have an account yet?
								<a href="Registeration.jsp" class="register">
									Create an account
								</a>
							</div>
						</fieldset>
					</form>
					<!-- start: COPYRIGHT -->
					<div class="copyright">
						2014 &copy; Rapido by cliptheme.
					</div>
					<!-- end: COPYRIGHT -->
				</div>
				<!-- end: LOGIN BOX -->
				<!-- start: FORGOT BOX -->
				
				<!-- end: FORGOT BOX -->
				<!-- start: REGISTER BOX -->
				
				<!-- end: REGISTER BOX -->
			</div>
		</div>
		<!-- start: MAIN JAVASCRIPTS -->
		<!--[if lt IE 9]>
		<script src="respond.min.js"></script>
		<script src="excanvas.min.js"></script>
		<script type="text/javascript" src="jQuery/jquery-1.11.1.min.js"></script>
		<![endif]-->
		<!--[if gte IE 9]><!-->
		<!-- <script src="js/jquery-2.1.1.min.js"></script>
		<![endif]
		<script src="js/jquery-ui-1.10.2.custom.min.js"></script> -->
<!-- 		<script src="js/bootstrap.min.js"></script>
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
		end: MAIN JAVASCRIPTS
		start: JAVASCRIPTS REQUIRED FOR SUBVIEW CONTENTS
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
		end: JAVASCRIPTS REQUIRED FOR SUBVIEW CONTENTS
		start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY
		<script src="js/ckeditor.js"></script>
		<script src="js/jquery.js"></script>
		<script src="js/form-validation1.js"></script>
		<script src="js/jquery.inputlimiter.1.3.1.min.js"></script>
		<script src="js/jquery.autosize.min.js"></script>
		<script src="js/select2.min.js"></script>
		<script src="js/jquery.maskedinput.js"></script>

		<script src="js/jquery.maskMoney.js"></script>
		<script src="js/bootstrap-datepicker.js"></script>
		<script src="js/bootstrap-timepicker.min.js"></script>
		<script src="js/bootstrap-colorpicker.js"></script>
		<script src="js/commits.js"></script>
		<script src="js/bootstrap-colorpalette.js"></script>
		<script src="js/jquery.bootstrap-touchspin.min.js"></script>
		<script src="js/jquery.tagsinput.js"></script>
		<script src="js/bootstrap-fileupload.min.js"></script>
	

		<script src="js/form-elements.js"></script>
		
		 -->
		<script src="js/jquery-2.1.1.min.js"></script>
		<!--<![endif]-->
		<script src="js/jquery-ui-1.10.2.custom.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.icheck.min.js"></script>
		<script src="js/jquery.transit.js"></script>
		<script src="js/jquery.touchSwipe.min.js"></script>
		<script src="js/main.js"></script>
		
		<!-- end: MAIN JAVASCRIPTS -->
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/login.js"></script>
		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script>
			jQuery(document).ready(function() {
				Main.init();
				Login.init();
			});
		</script>
	</body>
	<!-- end: BODY -->
</html>