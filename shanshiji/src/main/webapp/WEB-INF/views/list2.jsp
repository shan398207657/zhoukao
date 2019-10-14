<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>
<body>
<table>
	<tr align="center">
		<td colspan="11">百分比排序页面</td>
	</tr>
	
	<tr>
		<td>编号</td>
		<td>名称</td>
		<td>价格</td>
		<td>售出百分比</td>
	</tr>
	
	<c:forEach items="${goods }" var="g">
		<tr>
			<td>${g.id }</td>
			<td>${g.name }</td>
			<td>${g.price }</td>
			<td>${g.count }</td>
		</tr>
	</c:forEach>
	
	<tr align="center">
		<td colspan="11">${page }</td>
	</tr>
	<tr align="center">
		<td colspan="11"><input type="button" value="返回list页面" onclick="ck()"> </td>
	</tr>
</table>
<script type="text/javascript">
	function page(i){
		location.href="list1?currentPage="+i;
	}
	
	function ck(){
		location.href="list1";
	}
</script>

</body>
</html>