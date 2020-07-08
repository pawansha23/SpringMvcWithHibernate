<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Accounts</h1>
	<c:if test="${!empty accounts}">
		<table align="left" border="1">
			<tr>
				<th>Account ID</th>
				<th>Account Name</th>
				<th>Account Balance</th>
				<th>Age</th>
				<th>Profile Pic</th>
				<th>Show Document</th>
			</tr>

			<c:forEach items="${accounts}" var="acc">
				<tr>
					<td><c:out value="${acc.accno}" /></td>
					<td><c:out value="${acc.accName}" /></td>
					<td><c:out value="${acc.balance}" /></td>
					<td><c:out value="${acc.age}" /></td>
					<td><img alt="img" src="data:image/jpeg;base64,${acc.dbImage}" /></td>
					<td>
					<td><a href="/SpringMvcHibernateSql/showPdf/${acc.accno}">Same
							Page</a> <br /> <a
						href="/SpringMvcHibernateSql/showPdfPage/${acc.accno}">Another
							Page</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


	<c:if test="${!empty oneAccount}">

		<iframe width="50%" height="700px"
			src="data:application/pdf;base64,${oneAccount.dbDoc}"></iframe>

	</c:if>

	<h4>
		<h2>
			<a href="/SpringMvcHibernateSql/addnewAccount">Add new Account</a>
		</h2>
		<h2>
			<a href="/SpringMvcHibernateSql">Homepage</a>
		</h2>

	</h4>

</body>
</html>