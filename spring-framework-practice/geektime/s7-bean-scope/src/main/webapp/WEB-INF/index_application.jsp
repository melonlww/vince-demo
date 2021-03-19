<?xml version="1.0" encoding="UTF-8" ?>
<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" />
<html>
    <head>
        <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
    </head>
    <body>
        <br>userApplication.id : ${userApplication.id} </br>
        <br>userApplication.name : ${userApplication.name} </br>
        <br>applicationScope['scopedTarget.user7'].id : ${applicationScope['scopedTarget.user7'].id} </br>
        <br>applicationScope['scopedTarget.user7'].name : ${applicationScope['scopedTarget.user7'].name} </br>
    </body>
</html>