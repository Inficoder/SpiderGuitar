<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHow All</title>
</head>
<body>
    <table>
    <tr>     
      <th>编号</th><th>title</th><th>image</th><th>other</th><th colspan="2">operate</th>
    </tr>
    <c:forEach items="${guitarchords}" var="gcs">
        <tr>
        <td>${gcs.id }</td><td>${gcs.title }</td><td>${gcs.image }</td><td>${gcs.other}</td>
        <td><a class="update" href="${gcs.id}">chg</a></td>   <!-- 修改 -->
        <td><a class="delete" href="${gcs.id}">del</a></td>           <!-- 删除 -->
        </tr>
     </c:forEach>
   </table>  
</body>
</html>