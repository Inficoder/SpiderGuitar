<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="/spiderGuitars/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">
  <script type="text/javascript" src="/spiderGuitars/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="/spiderGuitars/js/ajax.js"></script>
<title>Guitar Chords</title>
</head>
<body>
<div class="container">
<a href="/spiderGuitars/index.jsp"><h2>Index</h2></a>
<hr>
<div class="container" style="width:1100px;height:450px">
     <c:forEach items="${Chords}" var="gcs">
        <div class="contain er" style="float:left;margin:10px 0 0 10px;width:30%;height:50%;border:0px solid #F00">
		 <div class="guitarImage" style="width:100%;height:76%;margin:2% 0 0 0;border:0px solid #F00">
		    <a href="${gcs.g_url}" target="_blank"><image src="${gcs.g_image }" style="width:100%;height:100%"></image></a>
		 </div>
		 <div class="guitarTitle" style="width:100%;height:20%;margin:0 0 0 0;border:0px solid #F00">
		    <h5>${gcs.g_title }</h5>
		 </div> 
	  </div>
     </c:forEach>

   <div class="btn-group" role="group" aria-label="divPage" style="margin:0 0 0 40%">
  	 <button type="button" class="btn btn-default" onclick="jumpPage(1)">首页</button>
     <button type="button" class="btn btn-default" onclick="jumpPage(${pageNum}-1 > 0 ? ${pageNum}-1 : 1)">上一页</button>
     <button type="button" class="btn btn-default" onclick="">...</button>
     <%--   <c:forEach var="i" begin="1" end="3" varStatus="status">
       <button type="button" class="btn btn-default" onclick="jumpPage(${pageNum}+${status.index})">${pageNum}+1</button>
       </c:forEach> --%>
     <button type="button" class="btn btn-default" onclick="jumpPage(${pageNum}+1 < ${pageAllCount} ? ${pageNum}+1 : ${pageAllCount})">下一页</button>
 	 <button type="button" class="btn btn-default" onclick="jumpPage(${pageAllCount})">尾页</button>
   </div>
</div>
<hr>
<script>
   function jumpPage(page){
	   location.href="/spiderGuitars/guitarController/showDiv/page/"+page;
   }
</script>
</div>
</body>
</html>