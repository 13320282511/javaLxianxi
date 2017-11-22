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
<form action="NewsServlet" method="post">
    	<input type="hidden" name="oprate" value="addnews"/>
    	<input type="text" name="newstitle" placeholder="请输入标题"/><br/>
    	新闻栏目
    	<select name="newstype">
    	   <option value="html">html</option>
    	   <option value="Javascript">Javascript</option>
    	   <option value="oracle">oracle</option>
    	</select>
    	<br/>
    	<textarea id="content" name="newscontent" rows="8" cols="70"></textarea><br/>
    	<input type="submit" value="添加"/>
    </form>
</body>
</html>