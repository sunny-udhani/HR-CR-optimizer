<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.text.*" %>

<%
String s = request.getParameter("period");
String[] period = s.split("-");
System.out.print(period[0]);
System.out.print(period[0]);
DateFormat formatter = null;
    Date convertedDate = null;
    Date convertedDate1 = null;
    // Creating SimpleDateFormat with yyyyMMdd format e.g."20110914"
    
    formatter = new SimpleDateFormat("MM/dd/yyyy");
    try {
		convertedDate = (Date) formatter.parse(period[0]);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("Date : " + convertedDate);
    
    try {
		convertedDate1 = (Date) formatter.parse(period[1]);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("Date  : " + convertedDate1);
    
	 int d1 = convertedDate1.getDate();
	 int d = convertedDate.getDate();

	 JSONObject obj=new JSONObject();
	 obj.put("val",d1-d+1);
	 response.getWriter().print(obj);
	 System.out.println(d1-d+1);

	 
	 out.flush();
%>