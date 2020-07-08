<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <html xmlns:th="https://www.thymeleaf.org">
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <form action="#" th:action="@{/}" th:object="${account}" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" th:field="*{accname}" /></td>
                    <td th:if="${#fields.hasErrors('accname')}" th:errors="*{accname}">Name should be 2 - 7 characters long</td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td><input type="text" th:field="*{age}" /></td>
                    <td th:if="${#fields.hasErrors('age')}" th:errors="*{age}">Age is less than 18</td>
                </tr>
                <tr>
                <tr>
                    <td>Account number:</td>
                    <td><input type="text" th:field="*{accno}" /></td>
                    <td th:if="${#fields.hasErrors('accno')}" th:errors="*{accno}">Please check the account number</td>
                </tr>
                <tr>
                 <tr>
                <tr>
                    <td>Account Balance:</td>
                    <td><input type="text" th:field="*{balance}" /></td>
                    <td th:if="${#fields.hasErrors('balance')}" th:errors="*{balance}">Balance Can't be null</td>
                </tr>
                <tr>
                    <td><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
