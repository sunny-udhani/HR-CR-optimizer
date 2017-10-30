<%@ page language="java" import="javax.sql.*" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<!-- <script>
  var Login = function(){
	init : function(){

String fname = request.getParameter("email");


Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student444","root","");

Statement st = con.createStatement();


ResultSet rs=st.executeQuery("Select * from register where username="+fname");

		 if(rs.next())
         {    
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(new JSON().toJSON(true));

         }else {
        	 response.setContentType("application/json");
        	 response.setCharacterEncoding("UTF-8");
        	 response.getWriter().write(new JSON().toJSON(false));

        	  }
		/* if(rs.next()){
			  out.print( "{ result: 'true' }" );
		}
		else{
			  out.print( "{ result: 'false' }" );
		} */

rs.close();	
st.close();
con.close();
 	};
}(); 
</script> -->
</head>
<body>
<%
String fname = request.getParameter("email");


Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student444","root","");

Statement st = con.createStatement();


ResultSet rs=st.executeQuery("Select * from register where username='"+fname+"' ");

		 if(rs.next())
         {    
             out.println("<font color=red>");
             out.println("Name already taken");
             out.println("</font>");

         }else {

             out.println("<font color=green>");
             out.println("Available");
             out.println("</font>");

         }
		 %> 
<!-- <script>
			jQuery(document).ready(function() {
				
				Login.init();
			});
		</script>  -->
</body>
</html>