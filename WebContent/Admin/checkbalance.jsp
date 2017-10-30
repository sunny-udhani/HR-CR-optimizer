<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%@page import="java.text.*" %>
<%

String k = request.getParameter("k");
String j = request.getParameter("j");

Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student444","root","");

PreparedStatement st = con.prepareStatement("Select * from leave_entitlement where employee=? and leavetype=?");
st.setString(1, j);
st.setString(2, k);
ResultSet rs = st.executeQuery();

if(rs.next())
	{

	out.print(rs.getFloat("LeaveEntitlement_days"));	
	/* JSONObject obj=new JSONObject();
	obj.put("val",rs.getFloat("LeaveEntitlement_days"));
	response.getWriter().print(obj);
 */
	}
else{
	
	out.print("No leaves Entitled");
}
out.flush();
%>