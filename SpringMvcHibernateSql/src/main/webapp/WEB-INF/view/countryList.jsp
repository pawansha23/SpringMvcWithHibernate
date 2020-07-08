<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Countries</h1>
	<c:if test="${!empty countries}">
		<table align="left" border="1">
			<tr>
				<th>Country ID</th>
				<th>Country Name</th>
			</tr>

			<c:forEach items="${countries}" var="country">
				<tr>
					<td><c:out value="${country.cid}" /></td>
					<td><c:out value="${ country.cname}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="/SpringMvcHibernateSql/country"><button>Add Country</button></a>
		<br/>
		<a href="/SpringMvcHibernateSql"><button>Home Page</button></a>
		<br/>
		<a href="/SpringMvcHibernateSql/changeCountry"><button>Change Country</button></a>
		<br/>
		<a href="/SpringMvcHibernateSql/deleteCountry"><button>Delete Country</button></a>
		<br/>
	</h4>
</body>
</html>