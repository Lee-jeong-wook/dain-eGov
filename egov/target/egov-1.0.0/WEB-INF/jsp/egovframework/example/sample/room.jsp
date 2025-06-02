<%@page import="egovframework.example.sample.service.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>My first three.js app</title>
    <style>
      body { margin: 0; }
      canvas { display: block; }
    </style>
<script type="importmap">
{
  "imports": {
    "three": "https://cdn.jsdelivr.net/npm/three@0.158.0/build/three.module.js",
    "three/addons/": "https://cdn.jsdelivr.net/npm/three@0.158.0/examples/jsm/"
  }
}
</script>
  </head>
  <body>
    <div id="app"></div>
<script type="text/javascript">
	const id = "${vo.id}";
	const computer = ${vo.computer};
    console.log(computer);
</script>
    <script type="module" src="./js/script.js?v=<%=System.currentTimeMillis() %>"></script>
  </body>
  <script>
    
  </script>
</html>