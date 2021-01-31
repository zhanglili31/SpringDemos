<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.jlu.entity.Person"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 this is result 
  <br/>
 	 查询的数据
 ${requestScope.student.id } 
 ${requestScope.student.c1 }
  <br/>
</body>
</html>