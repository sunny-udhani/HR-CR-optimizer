<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%
session = request.getSession(false);
session.invalidate();
String s = request.getParameter("email");

Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student444","root","");

PreparedStatement st = con.prepareStatement("Select * from register where username=?");
st.setString(1, s);
ResultSet rs = st.executeQuery();




		 if(rs.next())
         {    
    /* JSONObject json = new JSONObject();
   json.writeJSONString(out); */
   System.out.println(rs.getString("username"));
    out.print(false);
         }
		 else
		 {
			out.print(true);
		 }
 
    out.flush();
%>