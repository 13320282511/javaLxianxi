<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table width="1000px" cellpadding="0px" cellspacing="0px" border="1px" style="border:1px solid gray; border-collapse: collapse;">
    	<tr>
    		<th><input type="checkbox" name="qx" onclick=""/></th>
    		<th>文章ID</th>
    		<th>文章标题</th>
    		<th>所属栏目</th>
    		<th>创建时间</th>
    		<th>是否审核</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${newslist}" var="news">
	    	<tr>
	    		<td><input type="checkbox" name="deleteId" value="${news.newsid }"/></td>
	    		<td>${news.newsid }</td>
	    		<td>${news.newstitle }</td>
	    		<td>${news.newsType }</td>
	    		<td>${news.createtime }</td>
	    		<td>${news.newsStatus }</td>
	    		<td>
	    		<a href="NewsServlet?oprate=toupdate&id=${news.newsid}">编辑 </a>
	    		| 
	    		<a href="NewsServlet?oprate=delete&id=${news.newsid }">删除</a></td>
	    	</tr>
    	</c:forEach>
    	</table>
</body>
</html>