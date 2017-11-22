<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="NewsServlet" method="post">
    	<input type="hidden" value="${news.newsid}" name="id"/>
    	<input type="hidden" name="oprate" value="updatenews"/>
    	<input type="text" name="newstitle" value="${news.newstitle}" placeholder="请输入标题"/><br/>
    	新闻栏目
    	<select name="newstype">
    		
    	   <option <c:if test="${news.newsType==\"html\"}">selected</c:if> value="html">html</option>
    	   <option <c:if test="${news.newsType==\"Javascript\"}">selected</c:if> value="Javascript">Javascript</option>
    	   <option <c:if test="${news.newsType==\"oracle\"}">selected</c:if> value="oracle">oracle</option>
    	</select>
    	<br/>
    	<textarea id="content" name="newscontent" rows="8" cols="70">${news.newsContent}</textarea><br/>
    	<input type="submit" value="确定修改"/>
    </form>
</body>
</html>