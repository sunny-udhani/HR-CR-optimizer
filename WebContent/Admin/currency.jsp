<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.xml.*"%>

<%
/* session = request.getSession(false);
session.invalidate(); */
//String s = request.getParameter("email");

Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student444","root","");

PreparedStatement st = con.prepareStatement("Select * from currency");

ResultSet rs = st.executeQuery();

String[] s={"lol"};
/* List ls = new ArrayList();
int i = 0;


		  while(rs.next())
         {    
    /* JSONObject json = new JSONObject();
   json.writeJSONString(out); 
   System.out.println(rs.getString("currencyname"));
   //out.print("{value: "+i+", text: '"+rs.getString("currencyname")+"'}");
   ls.add(i, rs.getString("currencyname"));
   System.out.println(i++);
         } 
		  */
		  System.out.println(s[0]);
		out.print(s[0]); 
	 
	/* JSONObject json = new JSONObject();
	   json.writeJSONString(out); */
    out.flush();
%>