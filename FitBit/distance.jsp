



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>



<%@page import="java.sql.*"%>



<sql:setDataSource

	driver = "com.sap.db.jdbc.Driver"

	url = "jdbc:sap://shatechcrunchhana.sapvcm.com:30015?reconnect=true"

	user = "fitbitreaduser"

	password = "FitBit123" />



<sql:query var="myquery">

SELECT top 60 * FROM "FITBIT"."FB_DISTANCE"
where user_surr_id = ?
order by 2 desc, 3 desc
<sql:param value="${param.userid}" />

</sql:query>



<!doctype html>

<html>

<body>



<ul>

	<c:forEach var="row" items="${myquery.rowsByIndex}">

		<li>

			<c:out value="${row[0]}" />, 
			<c:out value="${row[1]}" />, 
			<c:out value="${row[2]}" />, 
			<c:out value="${row[3]}" />

		</li>

	</c:forEach>

</ul>



<body>

<html>

