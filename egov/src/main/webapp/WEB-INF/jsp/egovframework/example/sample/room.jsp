<%@page import="egovframework.example.sample.service.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>My first three.js app</title>
    <style>
      body { margin: 0; }
      canvas { display: block; }
    </style>
    <c:if test="${not empty error}">
      <script>
        alert("${error}");
      </script>
    </c:if>
<script type="importmap">
{
  "imports": {
    "three": "https://cdn.jsdelivr.net/npm/three@0.158.0/build/three.module.js",
    "three/addons/": "https://cdn.jsdelivr.net/npm/three@0.158.0/examples/jsm/"
  }
}
</script>
  </head>
  <style>
    .popup{
      width: 150px;
      height: 80px;
      position: fixed;
      top: 10px;
      left: 5px;
      z-index: 100;
    }
    .popup>div{
      width: 100%;
      height: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
      border-radius: 5px;
      background-color: white;
    }
    .popup *{
      color: white;
    }
    button{
      width: 80%;
      font-size: 24px;
      background-color: red;
      color: #fff;
      font-weight: 800;
      border: 0.5px;
      border-radius: 8px;
      cursor: pointer;
      box-shadow: 1px 1px 10px #bababa;
    }
    button:active{
      background-color: #aa0000;
    }
  </style>
  <body>
  <div class="popup">
    <div>
      <button onclick="return logout()">
        로그아웃
      </button>
    </div>
  </div>

    <div id="app">

    </div>
<script type="text/javascript">
	const id = "${vo.id}";
	const computer = ${vo.computer};

        const logout = () => {
          document.cookie = "id=; max-age=-1;";
          location.href = "login.do";
        };
</script>
    <script type="module" src="./js/script.js?v=<%=System.currentTimeMillis() %>"></script>
  </body>
</html>