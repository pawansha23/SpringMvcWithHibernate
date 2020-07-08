<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<form:form method="post" action="addAccount" commandName="accountVO"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="accno">
						Account number : 
					</form:label></td>
				<td><form:input path="accno" disabled="false" readonly="false" /></td>
				<td><form:errors path="accno" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="accName">
						Account Name :
					</form:label></td>
				<td><form:input path="accName" /></td>
				<td><form:errors path="accName" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="balance">
						Account Balance :
					</form:label></td>
				<td><form:input path="balance" /></td>
				<td><form:errors path="balance" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="age">
						Age :
					</form:label></td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="image">
				Profile Pic: 
				</form:label></td>
				<td><form:input type="file" path="image" /></td>
			</tr>

			<tr>
				<td><form:label path="image">
				Document: 
				</form:label></td>
				<td><form:input type="file" path="customerDoc" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="ADD" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>