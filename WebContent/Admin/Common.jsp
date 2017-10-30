
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="-1">
<title></title>
</head>
<body>


	<%
    response.setHeader( "Pragma", "no-cache" );
	response.setHeader("Cache-Control","private, no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
    response.setDateHeader( "Expires", 0 );
	%>
	<div id="slidingbar-area">
		<%@ include file="SlidingBar.jsp" %>
	</div>
	<!-- end: SLIDING BAR -->
	<div class="main-wrapper">
		<!-- start: TOPBAR -->
		<header class="topbar navbar navbar-inverse navbar-fixed-top inner">
		<!-- start: TOPBAR CONTAINER --> <%@ include file="header.jsp"%>
		<!-- end: TOPBAR CONTAINER --> </header>
		<!-- end: TOPBAR -->
		<!-- start: PAGESLIDE LEFT -->
		<a class="closedbar inner hidden-sm hidden-xs" href="#"> </a>
		<nav id="pageslide-left" class="pageslide inner">
		<%@ include file="left-menu.jsp"%>
		</nav>
		<!-- end: PAGESLIDE LEFT -->
		
		<!-- start: PAGESLIDE RIGHT -->
		<div id="pageslide-right" class="pageslide slide-fixed inner">
		<%@ include file="Rightwrapper.jsp"%>
		</div>
		<!-- end: PAGESLIDE RIGHT -->
		<!-- start: MAIN CONTAINER -->
		<div class="main-container inner">
			<!-- start: PAGE -->
			<div class="main-content">
				
				<%@ include file="Panelconfiguration.jsp"%>
				
				<div class="container">
					<!-- start: PAGE HEADER -->
					<!-- start: TOOLBAR -->
					<div class="toolbar row">
						<div class="col-sm-6 hidden-xs">
							<div class="page-header">
								<!-- <h1>
									Form Validation <small>form validation samples</small>
								</h1> -->
							</div>
						</div>
						<%@ include file="right-menu.jsp"%>
					</div>
				</div>
				<!-- end: TOOLBAR -->
				<!-- end: PAGE HEADER -->
				</body>
</html>