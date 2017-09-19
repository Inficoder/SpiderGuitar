<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Index</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="/spiderGuitars/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">
  <script type="text/javascript" src="/spiderGuitars/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="/spiderGuitars/js/ajax.js"></script>
  
  <script>
     function showSearch(){
    	var key = document.getElementById("search").value;
    	location.href="/spiderGuitars/guitarController/showSearch/"+key;
     }
  </script>
</head>

<body>
<h2>Guitar Chords</h2>
<div class="container">
<!-- <a href="/spiderGuitars/guitarController/showGuitarById/1">Select One</a><br> 
<a href="/spiderGuitars/guitarController/showAllGcs">ShowAll</a><br> -->
<a href="/spiderGuitars/guitarController/showDiv/page/1">click me! </a>
<hr>

     <input value="${key}" id="search" type="text" placeholder="搜索你想要的吉他谱"/>&nbsp<button onclick="showSearch()" >搜索</button>
      <br><br>
       <c:if test="${not empty key}">
           <p>${key}的搜索结果...</p>
       </c:if>
     <div class="container" id="showSearchs">
     <c:if test="${not empty search }">
         <c:forEach items="${search}" var="gcs">
             	 <div class="contain er" style="float:left;margin:10px 0 0 10px;width:30%;height:50%;border:0px solid #F00">
		 <div class="guitarImage" style="width:100%;height:76%;margin:2% 0 0 0;border:0px solid #F00">
		    <a href="${gcs.g_url}" target="_blank"><image src="${gcs.g_image}" style="width:282px;height:158.475px"></image></a>
		 </div>
		 <div class="guitarTitle" style="width:100%;height:20%;margin:0 0 0 0;border:0px solid #F00">
		    <h5>${gcs.g_title}</h5>
		 </div> 
	 </div>
         </c:forEach>
     </c:if>
     <c:if test="${empty search and not empty key}">
        <p>暂无相关吉他谱</p>
     </c:if>
     </div>

<hr>
--   inficoder@gmail.com
</div>


<div class="container" style="width:1100px;height:450px">

</div>	
<hr>


</body>
</html>
