<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="delete" modelAttribute="countryVO">
		<table>
			<tr>
				<td><form:label path="cid">
						Country ID : 
					</form:label></td>
				<td><form:input path="cid" disabled="false" readonly="false" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="DELETE" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>