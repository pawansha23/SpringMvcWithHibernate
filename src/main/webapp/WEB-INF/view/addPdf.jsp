<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<form:form method="post" action="createPdf" commandName="documentVO"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="docName">
						Document Name: 
					</form:label></td>
				<td><form:input path="docName" /></td>
				<td><form:errors path="docName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="docContent">
						Document Content:
					</form:label></td>
				<td><form:textarea path="docContent" /></td>
				<td><form:errors path="docContent" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="ADD" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>