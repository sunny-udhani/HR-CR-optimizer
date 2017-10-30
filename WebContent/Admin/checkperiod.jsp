<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.text.*" %>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>

<%
String p = request.getParameter("p");
String j = request.getParameter("j");

String k = request.getParameter("k");

String[] period = p.split("-");
System.out.print(period[0]);
System.out.print(period[1]);
DateFormat formatter = null;
  java.util.Date convertedDate = null;
  java.util.Date convertedDate1 = null;
    // Creating SimpleDateFormat with yyyyMMdd format e.g."20110914"
  java.util.Date from;
  java.util.Date to;
    formatter = new SimpleDateFormat("MM/dd/yyyy");
    try {
		convertedDate = (java.util.Date) formatter.parse(period[0]);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("Date : " + convertedDate);
    
    try {
		convertedDate1 = (java.util.Date) formatter.parse(period[1]);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("Date  : " + convertedDate1);
    
	 int d1 = convertedDate1.getDate();
	 int d = convertedDate.getDate();

	 Class.forName("com.mysql.jdbc.Driver");

	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student444","root","");

	 PreparedStatement st = con.prepareStatement("Select * from leave_entitlement where employee=? and leavetype=?");
	 st.setString(1, j);
	 st.setString(2, k);
	 ResultSet rs = st.executeQuery();

	 if(rs.next()){
		 
		 PreparedStatement st2 = con.prepareStatement("Select * from assignleavetoemployeevo where leave_entitlement=?");
		 st2.setInt(1, rs.getInt("LeaveEntitlement_id"));

		 ResultSet rs2 = st2.executeQuery();
		 System.out.println("in if");
	 
	 while(rs2.next())
	 	{
		 System.out.println("in while");
		from = rs2.getDate("AssignLeavetoEmployeeVO_startday");
		to = rs2.getDate("AssignLeavetoEmployeeVO_endday");
		
		boolean date1 = from.getDate() == convertedDate.getDate(); 
		boolean month1 = from.getMonth() == convertedDate.getMonth();
		boolean year1 = from.getYear() == convertedDate.getYear();
		
		boolean date2 = to.getDate() == convertedDate1.getDate(); 
		boolean month2 = to.getMonth() == convertedDate1.getMonth();
		boolean year2 = to.getYear() == convertedDate1.getYear();
		
		if ((date1 && month1 && year1) || (date2 && month2 && year2))
			{
			
				System.out.println("inside");
				out.print("The period chosen is incorrect. Already a leave assigned on that period");
				break;
			}
		System.out.println("outside");
	 	//out.print(rs.getFloat("LeaveEntitlement_days"));	
	 	/* JSONObject obj=new JSONObject();
	 	obj.put("val",rs.getFloat("LeaveEntitlement_days"));
	 	response.getWriter().print(obj);
	  */
	 	}
	 }
	/*  JSONObject obj=new JSONObject();
	 obj.put("val",d1-d+1); */
	 //response.getWriter().print(obj);
	 //System.out.println(d1-d+1);

	 System.out.println("Outside");
	 out.flush();
%>