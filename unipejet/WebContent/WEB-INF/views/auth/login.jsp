<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <title>UnipÃª Airlines</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
   <script src="<c:url value="/resources/js/login.js"/>" type="text/javascript"> </script>
    <style>
      html{
        height: 100%;
        min-height: 100%;
      }
    </style>
  </head>
  <body>
 
    <div class="login-wrap">
    <h2>Acesso</h2>
      <div class="form">
      &nbsp; &nbsp; &nbsp; &nbsp;<span style="color: blue"> ${sucesso} </span>
       <form:form servletRelativeAction="/login">
        <input type="text" placeholder="Login (email)" name="username" />
        <input type="password" placeholder="Senha" name="password" />
        <input type="submit" value="Logar"><br>
        
       </form:form>
    <p>     &nbsp;&nbsp;&nbsp;&nbsp; <a href="${spring:mvcUrl('UC#cadastroPage').build()}"> Ainda não tem uma conta? Cadastre-se aqui! </a> </p>
      </div>
 
    </div>

  </body>
</html>
