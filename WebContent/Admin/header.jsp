<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div class="container">
		<div class="navbar-header">
			<a class="sb-toggle-left hidden-md hidden-lg" href="#main-navbar">
				<i class="fa fa-bars"></i>
			</a>
			<!-- start: LOGO -->
			<a class="navbar-brand" href="index.jsp"> <img src="images/l.png"
				alt="HRM" />
			</a>
			<!-- end: LOGO -->
		</div>
		<div class="topbar-tools">
			<!-- start: TOP NAVIGATION MENU -->
			<ul class="nav navbar-right">
				<!-- start: USER DROPDOWN -->
				<li class="dropdown current-user"><a data-toggle="dropdown"
					data-hover="dropdown" class="dropdown-toggle"
					data-close-others="true" href="#"> <img
						src="images/avatar-1-small.jpg" class="img-circle" alt=""> <span
						class="username hidden-xs">LOL</span> <i
						class="fa fa-caret-down "></i>
				</a>
					<ul class="dropdown-menu dropdown-dark">
						<li><a href="pages_user_profile.html"> My Profile </a></li>
						<li><a href="pages_calendar.html"> My Calendar </a></li>
						<li><a href="pages_messages.html"> My Messages (3) </a></li>
						<li><a href="login_lock_screen.html"> Lock Screen </a></li>
						<li><a href="LogIn.jsp"> Log Out </a></li>
					</ul></li>
				<!-- end: USER DROPDOWN -->
				<li class="right-menu-toggle"><a href="#"
					class="sb-toggle-right"> <i class="fa fa-globe toggle-icon"></i>
						<i class="fa fa-caret-right"></i> <span
						class="notifications-count badge badge-default hide"> 3</span>
				</a></li>
			</ul>
			<!-- end: TOP NAVIGATION MENU -->
		</div>
	</div>

</body>
</html>